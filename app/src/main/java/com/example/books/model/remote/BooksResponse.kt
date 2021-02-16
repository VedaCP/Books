package com.example.books

import com.example.books.model.remote.BooksDataClass
import com.google.gson.annotations.SerializedName

data class BooksResponse (@SerializedName ("mBooks")
                          val mBooks: List<BooksDataClass>)