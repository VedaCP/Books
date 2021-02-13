package com.example.books

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.books.model.local.BooksDataBase
import com.example.books.model.local.BooksEntity
import com.example.books.model.remote.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BooksRepository
    val booksEntityLiveDataFromDB: LiveData<List<BooksEntity>>

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
    fun getBooksById(id: String) : LiveData<BooksEntity> {
        return repository.getBooksById(id)
    }
  /*  fun getFetchBooksWhitCoroutines(id: String) = viewModelScope.launch {
        repository.getBooksById(id)
    }*/
}