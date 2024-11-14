package com.ilustris.theoneapptorulethemall.ui.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilustris.theoneapptorulethemall.api.TheOneService
import com.ilustris.theoneapptorulethemall.api.response.BookResponse
import com.ilustris.theoneapptorulethemall.api.response.BooksResponse
import com.ilustris.theoneapptorulethemall.ui.movies.MovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel( ) {

    sealed class BookState{
        object LoadingState: BookState()
        object ErrorState: BookState ()
        data class BooksState(val books: List<BookResponse>): BookState()
    }


    val state = MutableLiveData<BooksViewModel.BookState>()
    val theOneService = TheOneService()

    fun getBook() {
        viewModelScope.launch (Dispatchers.IO){
            val book = theOneService.getBook()

            state.postValue(BookState.BooksState(book.books))
        }


    }

}