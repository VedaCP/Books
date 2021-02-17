package com.example.books

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.books.model.local.BooksDataBase
import com.example.books.model.pojo.BooksEntity
import com.example.books.model.remote.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BooksRepository
    val booksEntityLiveDataFromDB: LiveData<List<BooksEntity>>


    init {
        val dao = BooksDataBase.getBooksDataBase(application).getBooksDao()
        repository = BooksRepository(dao)
        viewModelScope.launch {
            repository.getBooksWhitCoroutines()
        }
        booksEntityLiveDataFromDB = repository.listBooks
        Log.d("liveData", "$booksEntityLiveDataFromDB")
    }
   fun getFetchBooksWhitCoroutines() = viewModelScope.launch {
        repository.getBooksWhitCoroutines()
    }
    fun updateFavBooks(booksEntity: BooksEntity) = viewModelScope.launch {
        repository.updateFavBooks(booksEntity)
    }

   fun getAllFavBooks(): LiveData<List<BooksEntity>> = repository.listFavBooks

   fun getBooksById(id: String) : LiveData<BooksEntity> {
        return repository.getBooksById(id)
    }
   fun getFetchBooksWhitCoroutines(id: String) = viewModelScope.launch {
        repository.getBooksById(id)
    }
}