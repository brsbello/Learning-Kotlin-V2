package com.example.desafio2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio2.MainActivityArgs
import com.example.desafio2.adapters.MenuAdapter
import com.example.desafio2.databinding.FragmentPageRestaurantBinding
import com.example.desafio2.model.PlatesModel

class PageRestaurantFragment : Fragment() {

    private lateinit var binding: FragmentPageRestaurantBinding
    val args: MainActivityArgs by navArgs()

    // como receber o id que passou no RV, por enquanto coloquei 1
    val listToRecycler = args.restaurantList.listPlates

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageRestaurantBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView(listToRecycler)
    }

    private fun setupRecyclerView(platesList: MutableList<PlatesModel>) {
        binding.RVMenu.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MenuAdapter(platesList) {
                val action =
                    PageRestaurantFragmentDirections.actionPageRestaurantFragmentToDescriptionPlateFragment(
                        it.id
                    )
                findNavController().navigate(action)
            }
        }
    }
}