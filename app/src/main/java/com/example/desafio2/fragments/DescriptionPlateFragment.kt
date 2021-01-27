package com.example.desafio2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.desafio2.databinding.FragmentDescriptionPlateBinding

class DescriptionPlateFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionPlateBinding
    private val args : PageRestaurantFragmentArgs by navArgs()
    val oneArgs = args.listPlates.plateName
    val twoArgs = args.listPlates.plateDescription
    val threeArgs = args.listPlates.plateImage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionPlateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.TVFinalDescription.text = oneArgs
        binding.TVFinalName.text = twoArgs
        val finalImage = threeArgs
        Glide.with(this)
            .load(finalImage)
            .into(binding.IVFinalImage)    }
}