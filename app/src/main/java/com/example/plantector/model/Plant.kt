package com.example.plantector.model

import com.example.plantector.R

data class Plant(
    val name: String,
    val family: String,
    val img_dir: Int
)

class PlantList{
    companion object{
        fun makeDefaultFlowerList(): List<Plant> {
            return listOf(Plant("Dahlia", "Asteraceae", R.drawable.dahlia),
                Plant("Edelweiss", "Asteraceae", R.drawable.edelweiss),
                Plant("Hibiscus", "Malvaceae", R.drawable.hibiscus),
                Plant("Jasmine", "Oleaceae", R.drawable.jasmine),
                Plant("Lavender", "Lamiaceae", R.drawable.lavender),
                Plant("Lily", "Liliaceae", R.drawable.lily),
                Plant("Morning glory", "-", R.drawable.morning_glory),
                Plant("Narcissus(genus)", "Amaryllidaceae", R.drawable.narcissus_genus),
                Plant("Nymphaea", "Nymphaeaceae", R.drawable.nymphaea),
                Plant("Petunia", "Solanaceae", R.drawable.petunia),
                Plant("Rose", "Rosaceae", R.drawable.rose),
                Plant("Sunflower", "Asteraceae", R.drawable.sunflower),
                Plant("Tulip", "Liliaceae", R.drawable.tulip),
                Plant("Violet", "Violaceae", R.drawable.violet),
                Plant("Daisy", "Asteraceae", R.drawable.daisy),
                Plant("Dandelion", "-", R.drawable.dandelion)
            )
        }
    }
}

