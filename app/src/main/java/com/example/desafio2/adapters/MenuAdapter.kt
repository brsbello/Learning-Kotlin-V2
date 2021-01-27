package com.example.desafio2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio2.databinding.ItemMenuBinding
import com.example.desafio2.model.PlatesModel

class MenuAdapter(
    private val list: List<PlatesModel>,
    private val onPlateClicked: (PlatesModel) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(generic = list[position], onPlateClicked)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        private val binding: ItemMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(generic: PlatesModel, onPlateClicked: (PlatesModel) -> Unit) = with(binding) {
            val firstImage = generic.plateImage

            Glide.with(itemView.context)
                .load(firstImage)
                .into(IVImgDescription)

            TVDescription.text = generic.plateDescription

            itemView.setOnClickListener {
                onPlateClicked(generic)
            }
        }
    }

}