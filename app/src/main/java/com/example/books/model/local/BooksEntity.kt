package com.example.books.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "books_table")
data class BooksEntity(@PrimaryKey val list: String,
                       @SerializedName("id")
                       val id: String,
                       @SerializedName("books")
                       val books: String,
                       @SerializedName("Editorial")
                       val editorial: String,
                       @SerializedName("Autor")
                       val autor: String,
                       @SerializedName("Lugar de impresión")
                       val print: String,
                       @SerializedName("Páginas")
                       val pages: String)


