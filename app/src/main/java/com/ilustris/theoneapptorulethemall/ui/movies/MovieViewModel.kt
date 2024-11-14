package com.ilustris.theoneapptorulethemall.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilustris.theoneapptorulethemall.api.TheOneService
import com.ilustris.theoneapptorulethemall.api.response.MovieDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    sealed class MovieState {
        object LoadingState : MovieState()
        object ErrorState : MovieState()
        data class MoviesState(val movies: List<MovieDataResponse>) : MovieState()
    }

    val state = MutableLiveData<MovieState>()
    val theOneService = TheOneService()


    fun getMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = theOneService.getMovie()

            state.postValue(MovieState.MoviesState(movie.movies))
        }
    }
}
