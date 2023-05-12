package com.rmarenco.laboratorio05.ui.movie.billboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rmarenco.laboratorio05.R
import com.rmarenco.laboratorio05.data.model.MovieModel
import com.rmarenco.laboratorio05.databinding.FragmentBillBoardBinding
import com.rmarenco.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter

class BillBoardFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentBillBoardBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.AddMovieAction.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billBoardFragment_to_movieDescriptionFragment)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }
}