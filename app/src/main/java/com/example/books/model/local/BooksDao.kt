package com.example.books.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(list: List<BooksEntity>)

    @Query("SELECT * FROM books_table")
    fun getAllBooksDB(): LiveData<List<BooksEntity>>

/*    @Query("SELECT id FROM books_table")
    fun getBooksList(): LiveData<List<BooksEntity>>*/

    @Query("SELECT * FROM books_table WHERE id = :id")
    fun getBooksById(id: String) : LiveData<BooksEntity>


}