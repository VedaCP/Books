package com.example.books

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.books.databinding.ItemBooksBinding
import com.example.books.databinding.ItemTitleBinding

class TitleAdapter: RecyclerView.Adapter<TitleAdapter.TitleVH>() {

    private var listTitleAdapterItem = listOf<BooksEntity>()

    private var selectedItem = MutableLiveData<BooksEntity>()
    fun selectedItem(): MutableLiveData<BooksEntity> {
        return selectedItem
    }

    fun update(list: List<BooksEntity>) {
        listTitleAdapterItem = list
        notifyDataSetChanged()
    }

    inner class TitleVH(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder
        (binding.root), View.OnClickListener {
        fun bind(title: BooksEntity) {
            binding.tvEditorial.text = title.list
            binding.tvAutor.text = title.list
            binding.tvPrint.text = title.list
            binding.tvPages.text = title.list
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            selectedItem.value = listTitleAdapterItem[adapterPosition]
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleVH {
        return TitleVH(ItemTitleBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: TitleVH, position: Int) {
        val booksEntity = listTitleAdapterItem [position]
        holder.bind(booksEntity)
    }
    override fun getItemCount(): Int = listTitleAdapterItem.size
}