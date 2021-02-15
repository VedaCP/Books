package com.example.books.model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.books.BooksResponse
import com.example.books.model.local.BooksDao
import com.example.books.model.local.BooksEntity

class BooksRepository(private val dao: BooksDao) {

    private val services = BooksRetrofitClient.retrofitInstance()
    val listBooks: LiveData<List<BooksEntity>> = dao.getAllBooksDB()
    //val booksList: LiveData<List<BooksEntity>> = dao.getBooksList()

    fun converter(converter: List<BooksDataClass>) : List<BooksEntity> {
        val listBooksEntity : MutableList<BooksEntity> = mutableListOf()
        converter.map {
           listBooksEntity.add(BooksEntity(id = it.id,
               titulo = it.titulo, editorial = it.editorial,
               autor = it.autor, lugar_impresion = it.lugar_impresion,
                paginas = it.paginas))
        }
        return listBooksEntity
    }
    suspend fun getBooksWhitCoroutines() {
        //Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = BooksRetrofitClient.retrofitInstance().fetchBooksList()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    Log.d("REPO", "$it")
                    dao.insertAllBooks(converter(it.booksList))
                }
                false -> Log.d("ERROR", "${response.code()} : ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }
    }
    fun getBooksById(id: String): LiveData<List<BooksEntity>> = dao.getAllBooksDB()
}