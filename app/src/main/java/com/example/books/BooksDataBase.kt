package com.example.books

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [BooksEntity::class, Title::class], version = 1)
abstract class BooksDataBase : RoomDatabase() {

    abstract fun getBooksDao() : BooksDao
    companion object {
        private var INSTANCE : BooksDataBase? = null
        fun getDataBase(context: Context): BooksDataBase {
            return INSTANCE ?: synchronized(this){
                val temInstance = Room.databaseBuilder(context.applicationContext,
                BooksDataBase::class.java,
                "books_db")
                    .build()
                INSTANCE = temInstance
                temInstance
            }
        }
    }

}