package com.example.books

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BooksRepository
    val booksEntityLiveDataFromDB: LiveData<List<String>>

    init {
        val dao = BooksDataBase.getDataBase(application).getBooksDao()
        repository = BooksRepository(dao)
        viewModelScope.launch {
            repository.getBooksWhitCoroutines()
        }
        booksEntityLiveDataFromDB = repository.listBooks
    }
    fun getFetchBooksWhitCoroutines() = viewModelScope.launch {
        repository.getBooksWhitCoroutines()
    }
    fun getFetchBooksWhitCoroutines(id: String) = viewModelScope.launch {
        repository.getBooksById(id)
    }
}