package com.example.plantector.ui.plant.details

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.plantector.R
import com.example.plantector.databinding.FragmentHomeBinding
import com.example.plantector.databinding.FragmentPlantDetailsBinding
import com.example.plantector.model.Plant
import com.example.plantector.ui.home.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlantDetailsFragment(val plant: Plant) : Fragment() {
    private lateinit var plantDetailsViewModel: PlantDetailsViewModel
    private var _binding: FragmentPlantDetailsBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance(plant: Plant) = PlantDetailsFragment(plant)

    }



    private lateinit var viewModel: PlantDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        plantDetailsViewModel =
            ViewModelProvider(this).get(PlantDetailsViewModel::class.java)
        _binding = FragmentPlantDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailsIv.setImageResource(plant.img_dir)
        binding.detailsToolbar.title = plant.name
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlantDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}