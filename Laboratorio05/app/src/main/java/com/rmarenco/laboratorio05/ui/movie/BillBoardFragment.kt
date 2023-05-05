package com.rmarenco.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rmarenco.laboratorio05.R
import com.rmarenco.laboratorio05.databinding.FragmentBillBoardBinding

class BillBoardFragment : Fragment() {

    private lateinit var starWarsCardView: CardView
    private lateinit var addNewMovieButton: FloatingActionButton
    private lateinit var binding: FragmentBillBoardBinding
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

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
        bind()
        binding.lifecycleOwner = viewLifecycleOwner
        setViewModel()

        starWarsCardView.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_billBoardFragment_to_movieDescriptionFragment)
        }

        addNewMovieButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }

    private fun setViewModel() {
        binding.viewModel = viewModel
    }

    private fun bind() {
        starWarsCardView = view?.findViewById(R.id.movie1_cardView) as CardView
        addNewMovieButton = view?.findViewById(R.id.AddMovie_Action) as FloatingActionButton
    }
}