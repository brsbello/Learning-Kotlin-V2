package com.example.desafio2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.desafio2.adapters.MenuAdapter
import com.example.desafio2.databinding.FragmentPageRestaurantBinding
import com.example.desafio2.model.PlatesModel

class PageRestaurantFragment : Fragment() {

    lateinit var binding: FragmentPageRestaurantBinding

    fun setupRecyclerView(platesList: MutableList<PlatesModel>) {
        binding.RVMenu.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MenuAdapter(platesList) {
                val action =
                    PageRestaurantFragmentDirections.actionPageRestaurantFragmentToDescriptionPlateFragment(
                        it
                    )
                findNavController().navigate(action)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageRestaurantBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: PageRestaurantFragmentArgs by navArgs()
        val restaurant = args.restaurant
        Glide.with(this)
            .load(restaurant.firstImage)
            .into(binding.IVImgTop)
        binding.TVRestaurantName.text = restaurant.restaurantName

        setupRecyclerView(restaurant.listPlates)
    }
}