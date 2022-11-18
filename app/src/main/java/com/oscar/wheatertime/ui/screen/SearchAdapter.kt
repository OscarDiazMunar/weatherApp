package com.oscar.wheatertime.ui.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscar.wheatertime.databinding.PlaceItemBinding
import com.oscar.wheatertime.ui.models.PlaceUiModel

class SearchAdapter(private val dataSet: List<PlaceUiModel>) :
        RecyclerView.Adapter<SearchAdapter.ViewHolder>(){

    var onItemClick: ((PlaceUiModel) -> Unit)? = null

    inner class ViewHolder(private val itemBinding: PlaceItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(placeUiModel: PlaceUiModel){
            itemBinding.placeName.text = placeUiModel.name

            itemBinding.root.setOnClickListener{
                onItemClick?.invoke(placeUiModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place: PlaceUiModel = dataSet[position]
        holder.bind(place)
    }

    override fun getItemCount() = dataSet.size

}