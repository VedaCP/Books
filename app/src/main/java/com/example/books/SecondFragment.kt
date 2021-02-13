package com.example.books

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.books.databinding.FragmentSecondBinding
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

        var adapter = TitleAdapter()
        binding.rvTitle.adapter = adapter
        binding.rvTitle.layoutManager = GridLayoutManager(context, 2)
        viewModel.getBooksById(idTitle).observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {
                it?.let {
                    Log.d("segundo fragmento", "$it")
                   // adapter.update(it)
            }
        })
    }

}