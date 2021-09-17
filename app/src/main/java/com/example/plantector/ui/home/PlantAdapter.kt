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

class PlantAdapter(public val context: Context, private val plantList: List<Plant>) :
    RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(
            LayoutInflater.from(context).inflate(R.layout.plant_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }


    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.item_iv)
        val name: TextView = itemView.findViewById(R.id.item_name_tv)
        val family: TextView = itemView.findViewById(R.id.item_family_tv)
        val moreInfoButton: MaterialButton = itemView.findViewById(R.id.item_more_info_btn)

        fun bind(plant: Plant) {
            img.setImageResource(plant.img_dir)
            name.text = plant.name
            family.text = plant.family
        }

    }


}