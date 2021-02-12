package com.example.books

import android.util.Log
import androidx.lifecycle.LiveData

class BooksRepository(private val dao: BooksDao) {

    private val services = BooksRetrofitClient.retrofitInstance()
    val listBooks: LiveData<List<String>> = dao.getAllBooksDaoDB()

    fun converter(converter: List<String>) : List<BooksEntity> {
        val listBooksEntity = mutableListOf<BooksEntity>()
        converter.map {
            listBooksEntity.add(BooksEntity(it))
        }
        return listBooksEntity
    }
    fun converterTitle(books: BooksEntity) : List<BooksEntity> {
        val listTitle : MutableList<BooksEntity> = mutableListOf()

        books.map {
            listTitle.add(BooksEntity(it))
        }
        return listTitle
    }
    suspend fun getBooksWhitCoroutines() {
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = BooksRetrofitClient.retrofitInstance().fetchBooksList()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    dao.insertAllBooksDao(converterTitle(it))
                }
                false -> Log.d("ERROR", "${response.code()} : ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }
    }
    suspend fun title(id: String) {
        try {
            val response = BooksRetrofitClient.retrofitInstance().fetchBooksList()
            when (response.isSuccessful){
                true -> response.body()?.let {
                    dao.getAllBooksDaoDB()
                }
                false -> Log.d("ERROR", "${response.code()} : ${response.errorBody()}")
            }
        }
        catch (t: Throwable){
            Log.e("ERROR COROUTINA", t.message.toString())
        }
    }

    fun getBooksById(id: String): LiveData<List<String>> {
        return dao.getAllBooksDaoDB()
    }


}