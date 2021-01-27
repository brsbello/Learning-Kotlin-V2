package com.example.desafio2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio2.databinding.ItemRestaurantBinding
import com.example.desafio2.model.RestaurantModel
import com.bumptech.glide.Glide

class MyRestaurantListAdapter(
        private val list: List<RestaurantModel>,
        private val onRestaurantClicked: (RestaurantModel) -> Unit
) : RecyclerView.Adapter<MyRestaurantListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRestaurantBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(generic = list[position], onRestaurantClicked)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
            private val binding: ItemRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(generic: RestaurantModel, onRestaurantClicked: (RestaurantModel) -> Unit) = with(binding) {
            val firstImage = generic.firstImage

            Glide.with(itemView.context)
                    .load(firstImage)
                    .into(IVImgPrincipal)

            TVName.text = generic.restaurantName
            TVPlace.text = generic.restaurantPlace
            TVHour.text = generic.restaurantHour

            itemView.setOnClickListener {
                onRestaurantClicked(generic)
            }
        }
    }

}