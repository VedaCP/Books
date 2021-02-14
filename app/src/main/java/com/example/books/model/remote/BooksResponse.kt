package com.example.books

import com.example.books.model.remote.BooksDataClass
import com.google.gson.annotations.SerializedName

data class BooksResponse (@SerializedName ("books_list") val booksList: List<BooksDataClass>)