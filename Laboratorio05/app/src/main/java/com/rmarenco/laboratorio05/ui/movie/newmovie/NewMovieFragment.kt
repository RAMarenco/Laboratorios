package com.rmarenco.laboratorio05.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rmarenco.laboratorio05.databinding.FragmentNewMovieBinding
import com.rmarenco.laboratorio05.ui.movie.billboard.MovieViewModel

class NewMovieFragment : Fragment() {
    private lateinit var binding: FragmentNewMovieBinding
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewModel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("Status:", status)
                    viewModel.clearStatus()
                    Toast.makeText(requireContext(), status, Toast.LENGTH_LONG).show()
                }

                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("Status", status)
                    Log.d("Movies", viewModel.getMovies().toString())
                    Toast.makeText(requireContext(), status, Toast.LENGTH_LONG).show()
                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}