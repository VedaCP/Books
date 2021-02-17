package com.example.books.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.books.model.pojo.BooksEntity

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(list: List<BooksEntity>)

    @Query("SELECT * FROM books_table")
    fun getAllBooksDB(): LiveData<List<BooksEntity>>

    @Query("SELECT * FROM books_table WHERE id = :id")
    fun getBooksById(id: String) : LiveData<BooksEntity>

    @Update
    suspend fun updateFavBooks(booksEntity: BooksEntity)

    @Query("SELECT * FROM books_table WHERE fav = 1")
    fun getAllFavBooks(): LiveData<List<BooksEntity>>


}