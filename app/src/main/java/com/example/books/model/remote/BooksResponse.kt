package com.example.books

import com.google.gson.annotations.SerializedName

data class BooksResponse (@SerializedName ("book_list")
                          val books: List<String>,
                          @SerializedName("Editorial")
                          val editorial: String,
                          @SerializedName("Autor")
                          val autor: String,
                          @SerializedName("Lugar de impresión")
                          val print: String,
                          @SerializedName("Número de páginas")
                          val pages: String)