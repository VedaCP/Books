package com.example.books.model.remote

import com.example.books.BooksResponse
import com.example.books.model.pojo.BooksEntity
import retrofit2.Response
import retrofit2.http.GET

interface BooksAPI {

    @GET("books/list")
    suspend fun fetchBooksList(): Response<BooksEntity>
}