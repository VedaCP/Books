package com.example.books.model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.books.BooksResponse
import com.example.books.model.local.BooksDao
import com.example.books.model.local.BooksEntity

class BooksRepository(private val dao: BooksDao) {

    private val services = BooksRetrofitClient.retrofitInstance()
    val listBooks: LiveData<List<BooksEntity>> = dao.getAllBooksDB()

    fun converter(converter: List<BooksResponse>) : List<BooksEntity> {
        val listBooksEntity : MutableList<BooksEntity> = mutableListOf()
        converter.map {
           listBooksEntity.add(BooksEntity(it.autor, it.editorial, it.print, it.pages,))
        }
        return listBooksEntity
    }
    suspend fun getBooksWhitCoroutines() {
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = BooksRetrofitClient.retrofitInstance().fetchBooksList()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                  dao.insertAllBooks(it)
                }
                false -> Log.d("ERROR", "${response.code()} : ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.e("ERROR COROUTINA", t.message.toString())
        }
    }
    fun getBooksById(id: String): LiveData<BooksEntity> {
        return dao.getBooksById(id)
    }
}