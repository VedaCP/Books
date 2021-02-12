package com.example.books

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksRetrofitClient {
    companion object {
        private const val URL_BASE = "https://www.mockable.io/a/#/space/demo4156558/rest"
        fun retrofitInstance(): BooksAPI {
            val retrofitClient = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitClient.create(BooksAPI::class.java)
        }
    }
}