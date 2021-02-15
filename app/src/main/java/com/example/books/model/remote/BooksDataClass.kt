package com.example.books.model.remote

import com.google.gson.annotations.SerializedName

data class BooksDataClass (@SerializedName ("id")
                           val id: String,
                           @SerializedName("book_list")
                           val titulo: String,
                           @SerializedName("editorial")
                           val editorial: String,
                           @SerializedName("autor")
                           val autor: String,
                           @SerializedName("lugar_impresion")
                           val lugar_impresion: String,
                           @SerializedName("paginas")
                           val paginas: String)
