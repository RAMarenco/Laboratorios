package com.rmarenco.laboratorio05.repositories

import com.rmarenco.laboratorio05.data.model.MovieModel

class MovieRepository (private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}