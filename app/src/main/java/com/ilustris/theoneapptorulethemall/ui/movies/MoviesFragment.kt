package com.ilustris.theoneapptorulethemall.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilustris.theoneapptorulethemall.api.response.MovieDataResponse
import com.ilustris.theoneapptorulethemall.databinding.FragmentMoviesBinding
import com.ilustris.theoneapptorulethemall.ui.movies.adapter.MoviesAdapter

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val movieViewModel by lazy { ViewModelProvider(this).get(MovieViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel =
            ViewModelProvider(this).get(MovieViewModel::class.java)

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root

observeViewModel()
        return root
    }

    override fun onStart() {
        super.onStart()
        movieViewModel.getMovie()
    }
    private fun observeViewModel() {
        movieViewModel.state.observe(viewLifecycleOwner)
        {
            when(it){
                MovieViewModel.MovieState.ErrorState -> TODO()
                MovieViewModel.MovieState.LoadingState -> TODO()
                is MovieViewModel.MovieState.MoviesState -> setupmoviesadapter(it.movies)
            }
        }


    }

    private fun setupmoviesadapter(moviesState: List<MovieDataResponse>) {
        binding.movieList.run {
            //layoutManager = GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL,false)
            adapter = MoviesAdapter(moviesState)

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
