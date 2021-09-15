package com.example.plantector.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plantector.R
import com.example.plantector.model.Plant
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso

class PlantAdapter(private val context: Context) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(LayoutInflater.from(context).inflate(R.layout.plant_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }



    class PlantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.item_iv)
        val name: TextView = itemView.findViewById(R.id.item_name_tv)
        val family:TextView = itemView.findViewById(R.id.item_family_tv)
        val moreInfoButton : MaterialButton = itemView.findViewById(R.id.item_more_info_btn)

        fun bind(plant:Plant){
            Picasso.get().load(plant.img_url).into(img)
            name.text = plant.name

        }

    }


}