package com.example.books.model.local

import android.content.Context
import android.icu.text.CaseMap
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [BooksEntity::class], version = 1)
abstract class BooksDataBase : RoomDatabase() {

    abstract fun getBooksDao() : BooksDao
    companion object {
        @Volatile
        private var INSTANCE : BooksDataBase? = null
        fun getBooksDataBase(context: Context): BooksDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                        BooksDataBase::class.java, "BooksDataBase")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
