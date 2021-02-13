package com.example.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.books.databinding.ItemBooksBinding
import com.example.books.model.local.BooksEntity

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksVH>() {

    private var listBooksEntityAdapterItem = listOf<BooksEntity>()

    private val selectedBooks = MutableLiveData<BooksEntity>()
    fun selectedItem() = selectedBooks

    fun update(list: List<BooksEntity>) {
        listBooksEntityAdapterItem = list
        notifyDataSetChanged()
    }
    inner class BooksVH(private val binding: ItemBooksBinding) : RecyclerView.ViewHolder
        (binding.root), View.OnClickListener {
            fun bind(booksEntity: BooksEntity) {
                binding.tvBooksList.text = booksEntity.list
                itemView.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            selectedBooks.value = listBooksEntityAdapterItem [adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        return BooksVH(ItemBooksBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        val booksEntity = listBooksEntityAdapterItem [position]
        holder.bind(booksEntity)
    }

    override fun getItemCount(): Int = listBooksEntityAdapterItem.size

}