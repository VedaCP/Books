package com.example.books

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class BooksEntity(@PrimaryKey val list: String)


