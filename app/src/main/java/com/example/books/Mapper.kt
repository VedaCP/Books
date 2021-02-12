package com.example.books

fun fromRemoteToEntityBooks(booksEntity: BooksEntity): List<BooksEntity>{
    return booksEntity?.list.map { BooksEntity() }
}