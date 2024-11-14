package com.ilustris.theoneapptorulethemall.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilustris.theoneapptorulethemall.databinding.FragmentBooksBinding
import com.ilustris.theoneapptorulethemall.ui.movies.MovieViewModel

class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding?= null

    private val binding get() = _binding!!

    val booksViewModel by lazy { ViewModelProvider ( this).get(BooksViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBooksBinding.inflate( inflater, container, false)
        return _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        booksViewModel.getBook()

    }
    fun observeViewModel( ) {
        booksViewModel.state.observe(this){
            when(it){
                is BooksViewModel.BookState.BooksState -> TODO()
                BooksViewModel.BookState.ErrorState -> TODO()
                BooksViewModel.BookState.LoadingState -> TODO()
            }
        }
    }
}