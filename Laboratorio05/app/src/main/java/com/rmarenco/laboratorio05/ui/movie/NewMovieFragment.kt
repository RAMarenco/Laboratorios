package com.rmarenco.laboratorio05.ui.movie

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputLayout
import com.rmarenco.laboratorio05.R
import com.rmarenco.laboratorio05.data.model.MovieModel

class NewMovieFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    lateinit var name_editText: TextInputLayout
    lateinit var category_editText: TextInputLayout
    lateinit var description_editText: TextInputLayout
    lateinit var qualification_editText: TextInputLayout
    lateinit var submit_Button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        addListener()
    }

    private fun addListener() {
        submit_Button.setOnClickListener {
            var movieAdded = addMovie()
            Log.d("Movie Added: ", movieAdded.toString())
            Log.d("Movies: ", viewModel.getMovies().toString())
            val toast = Toast.makeText(requireContext(), "Movie added", Toast.LENGTH_LONG).show()
            cleanInputs()
        }
    }

    private fun cleanInputs() {
        name_editText.editText?.text?.clear()
        category_editText.editText?.text?.clear()
        description_editText.editText?.text?.clear()
        qualification_editText.editText?.text?.clear()
    }

    private fun addMovie(): MovieModel {
        var movie_Name = name_editText.editText?.text.toString()
        var movie_Category = category_editText.editText?.text.toString()
        var movie_Description = description_editText.editText?.text.toString()
        var movie_Qualification = qualification_editText.editText?.text.toString()
        var movie = MovieModel(movie_Name, movie_Category, movie_Description, movie_Qualification)
        viewModel.addMovies(movie)
        return movie
    }

    private fun bind(view: View) {
        name_editText = view.findViewById(R.id.name_editText)
        category_editText = view.findViewById(R.id.category_editText)
        description_editText = view.findViewById(R.id.description_editText)
        qualification_editText = view.findViewById(R.id.calification_editText)
        submit_Button = view.findViewById(R.id.submit_Action)
    }
}