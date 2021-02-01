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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionPlateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args : DescriptionPlateFragmentArgs by navArgs()
        val plate = args.plates
        binding.TVFinalDescription.text = plate.plateDescription
        binding.TVFinalName.text = plate.plateName
        Glide.with(this)
            .load(plate.plateImage)
            .into(binding.IVFinalImage)
    }
}