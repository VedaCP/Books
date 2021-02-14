package com.example.books.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "books_table")
data class BooksEntity(@PrimaryKey val list: String,
                       @SerializedName("id")
                       val id: String,
                       @SerializedName("books")
                       val titulo: String,
                       @SerializedName("Editorial")
                       val editorial: String,
                       @SerializedName("Autor")
                       val autor: String,
                       @SerializedName("Lugar de impresión")
                       val lugar_impresion: String,
                       @SerializedName("Páginas")
                       val paginas: String)


