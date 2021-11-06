package com.parsamlm.plantector.view.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parsamlm.plantector.R
import com.parsamlm.plantector.model.Plant
import com.google.android.material.button.MaterialButton

lateinit var innerOnPlantItemClicked: PlantAdapter.OnPlantItemClicked

class PlantAdapter(
    val context: Context,
    private val onPlantItemClicked: OnPlantItemClicked,
    private var plantList: List<Plant>
) :
    RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private var searchList = ArrayList<Plant>()

    init {
        innerOnPlantItemClicked = this.onPlantItemClicked
        copyPlantListIntoSearchList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(
            LayoutInflater.from(context).inflate(R.layout.plant_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filter(query: String){
        if(query.isNotEmpty()){
            searchList.clear()
            plantList.forEach {
                if (it.name.startsWith(prefix = query, ignoreCase = true)){
                    searchList.add(it)
                    notifyDataSetChanged()
                }
            }
        }else{
            searchList.clear()
            copyPlantListIntoSearchList()
            notifyDataSetChanged()
        }
    }

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img: ImageView = itemView.findViewById(R.id.item_iv)
        private val name: TextView = itemView.findViewById(R.id.item_name_tv)
        private val family: TextView = itemView.findViewById(R.id.item_family_tv)
        private val moreInfoButton: MaterialButton = itemView.findViewById(R.id.item_more_info_btn)

        fun bind(plant: Plant) {
            img.setImageResource(plant.img_dir)
            name.text = plant.name
            family.text = plant.family
            moreInfoButton.setOnClickListener {
                innerOnPlantItemClicked.onMoreInfoButtonClicked(plant)
            }
        }

    }

    fun copyPlantListIntoSearchList(){
        plantList.forEach {
            searchList.add(it)
        }
    }

    interface OnPlantItemClicked {
        fun onMoreInfoButtonClicked(plant: Plant)
    }

}