package com.ilustris.theoneapptorulethemall.ui.books.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ilustris.theoneapptorulethemall.api.response.BookResponse
import com.ilustris.theoneapptorulethemall.api.response.BooksResponse

class BooksAdapter(val books:List<BookResponse>)  :RecyclerView.Adapter<BooksAdapter.BookViewHolder >() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(){

        }
    }
}