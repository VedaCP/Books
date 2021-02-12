package com.example.books

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksAPI {

    @GET("books/list")
    suspend fun fetchBooksList(): Response<BooksEntity>

    @GET("books/{books}/")
    suspend fun fetchByBooks(@Path("books")books: String) : Response<BooksEntity>
}