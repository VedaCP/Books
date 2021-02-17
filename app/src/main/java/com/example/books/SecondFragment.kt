package com.example.books

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.books.databinding.FragmentSecondBinding
import com.example.books.model.pojo.BooksEntity
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel : BooksViewModel by activityViewModels()
    var idTitle: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idTitle = it.getString("list", "")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBooksById(idTitle).observe(viewLifecycleOwner,
                {
                    it?.let {
                        binding.tvTitulo.text = it.titulo
                        binding.tvEditorial.text = it.editorial
                        binding.tvAutor.text = it.autor
                        binding.tvLugarImpresion.text = it.lugar_impresion
                        binding.tvPaginas.text = it.paginas
                        saveFav(it)
                        Log.d("segundo fragmento", "$it")
                    }
            })

    }
    fun saveFav (booksEntity: BooksEntity) {
        binding.btFav.setOnClickListener {
            if (booksEntity.fav) {
                booksEntity.fav = false
                viewModel.updateFavBooks(booksEntity)
                Toast.makeText(context, "Eliminado de fav", Toast.LENGTH_LONG).show()
            } else {
                booksEntity.fav = true
                viewModel.updateFavBooks(booksEntity)
                Toast.makeText(context, "Añadido a fav", Toast.LENGTH_LONG).show()
            }
        }
    }
}