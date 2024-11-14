package com.ilustris.theoneapptorulethemall.ui.movies.adapter

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ilustris.theoneapptorulethemall.R
import com.ilustris.theoneapptorulethemall.api.response.MovieDataResponse
import com.ilustris.theoneapptorulethemall.databinding.MovieItemLayoutBinding

class MoviesAdapter(val movies:List<MovieDataResponse>) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(){
            val movie = movies [adapterPosition]
            MovieItemLayoutBinding.bind(itemView).run {
                movieName.text = movie.title
                movieDescription.text = movie.description
                Glide.with (movieCover).load(movie.cover)
                    .into(movieCover)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
    return MovieViewHolder(view)
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData()
    }
}