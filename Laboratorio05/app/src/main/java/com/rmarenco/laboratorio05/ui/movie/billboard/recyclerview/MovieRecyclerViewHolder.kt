package com.rmarenco.laboratorio05.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.rmarenco.laboratorio05.data.model.MovieModel
import com.rmarenco.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
     fun bind (movie: MovieModel, clickListener: (MovieModel) -> Unit) {
         binding.movieTitle.text = movie.name
         binding.movieRating.text = movie.qualification

         binding.movieItemCardView.setOnClickListener {
             clickListener(movie)
         }
     }
}