package com.example.books.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "books_table")
data class BooksEntity(@SerializedName("id")
                       @PrimaryKey val id: String,
                       @SerializedName("ttulo")
                       val titulo: String,
                       @SerializedName("editorial")
                       val editorial: String,
                       @SerializedName("autor")
                       val autor: String,
                       @SerializedName("lugar_impresion")
                       val lugar_impresion: String,
                       @SerializedName("paginas")
                       val paginas: String,

                       var fav: Boolean)//Agregué ésta línea



