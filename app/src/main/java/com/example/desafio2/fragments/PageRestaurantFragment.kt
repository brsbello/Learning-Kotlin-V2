package com.example.desafio2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio2.adapters.MenuAdapter
import com.example.desafio2.databinding.FragmentPageRestaurantBinding
import com.example.desafio2.model.PlatesModel

class PageRestaurantFragment : Fragment() {

    private lateinit var binding: FragmentPageRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPageRestaurantBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
    //    @JvmStatic
    //    fun newInstance(param1: String, param2: String) =
    //        BlankFragment().apply {
    //            arguments = Bundle().apply {
    //                putString(ARG_PARAM1, param1)
    //                putString(ARG_PARAM2, param2)
    //            }
    //        }

    private fun setupRecyclerView(platesList: MutableList<PlatesModel>){
        binding.RVMenu.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MenuAdapter(platesList)
        }
    }

}