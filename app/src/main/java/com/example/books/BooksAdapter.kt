package com.example.books

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.books.databinding.ItemBooksBinding
import com.example.books.model.pojo.BooksEntity

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksVH>() {

    private var listBooksEntityAdapterItem = listOf<BooksEntity>()

    private var selectedBooks = MutableLiveData<BooksEntity>()
    fun selectedItem() = selectedBooks

    fun update(list: List<BooksEntity>) {
        listBooksEntityAdapterItem = list
        notifyDataSetChanged()
    }
    inner class BooksVH(private val binding: ItemBooksBinding) : RecyclerView.ViewHolder
        (binding.root), View.OnClickListener {
            fun bind(booksEntity: BooksEntity) {
                if(booksEntity.fav){
                    binding.ivFav.setColorFilter(Color.BLUE)
                } else {
                    binding.ivFav.setColorFilter(Color.RED)
                }
               binding.tvBooksList.text = booksEntity.id
               itemView.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            selectedBooks.value = listBooksEntityAdapterItem [adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.BooksVH {
        return BooksVH(ItemBooksBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BooksAdapter.BooksVH, position: Int) {
        val booksDataClass = listBooksEntityAdapterItem [position]
        holder.bind(booksDataClass)
    }

    override fun getItemCount(): Int = listBooksEntityAdapterItem.size

}