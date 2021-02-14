package com.example.books.model.remote

import com.google.gson.annotations.SerializedName

data class BooksDataClass (@SerializedName ("id")
                           val id: String,
                           @SerializedName("book_list")
                           val titulo: String,
                           @SerializedName("Editorial")
                           val editorial: String,
                           @SerializedName("Autor")
                           val autor: String,
                           @SerializedName("Lugar de impresión")
                           val lugar_impresion: String,
                           @SerializedName("Número de páginas")
                           val paginas: String)
