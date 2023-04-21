package com.rmarenco.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillBoardFragment : Fragment() {

    private lateinit var starWarsCardView: CardView
    private lateinit var addNewMovieButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        starWarsCardView.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_billBoardFragment_to_movieDescriptionFragment)
        }

        addNewMovieButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }

    private fun bind() {
        starWarsCardView = view?.findViewById(R.id.movie1_cardView) as CardView
        addNewMovieButton = view?.findViewById(R.id.AddMovie_Action) as FloatingActionButton
    }
}