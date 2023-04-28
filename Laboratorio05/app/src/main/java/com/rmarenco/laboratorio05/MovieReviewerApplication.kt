package com.rmarenco.laboratorio05

import android.app.Application
import com.rmarenco.laboratorio05.data.movies
import com.rmarenco.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}