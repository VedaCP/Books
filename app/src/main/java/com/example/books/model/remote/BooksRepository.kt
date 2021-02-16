package com.example.books.model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.books.model.local.BooksDao
import com.example.books.model.pojo.BooksEntity

class BooksRepository(private val dao: BooksDao) {

    private val services = BooksRetrofitClient.retrofitInstance()
    val listBooks: LiveData<List<BooksEntity>> = dao.getAllBooksDB()
    val listFavBooks = dao.getAllFavBooks()


    fun converter(converter: List<BooksDataClass>) : List<BooksEntity> {
        val listBooksEntity : MutableList<BooksEntity> = mutableListOf()
        converter.map {
           listBooksEntity.add(BooksEntity(id = it.id,
               titulo= it.titulo, editorial = it.editorial,
               autor = it.autor, lugar_impresion = it.lugar_impresion,
                paginas = it.paginas, fav = it.fav))
        }
        return listBooksEntity
    }
    suspend fun getBooksWhitCoroutines() {
        //Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = BooksRetrofitClient.retrofitInstance().fetchBooksList()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    Log.d("REPO", "${it}")
                    dao.insertAllBooks(converter(it.mBooks))
                }
                false -> Log.d("ERROR", "${response.code()} : ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }
    }
    fun getBooksById(id: String): LiveData<BooksEntity> = dao.getBooksById(id)

    suspend fun updateFavBooks(booksEntity: BooksEntity){
        dao.updateFavBooks(booksEntity)
    }
}