package com.example.books

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooksDao(list: List<BooksEntity>)

    @Query("SELECT * FROM books_table")
    fun getAllBooksDaoDB(): LiveData<List<String>>
}