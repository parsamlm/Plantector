package com.example.plantector.view.plant.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.plantector.databinding.FragmentPlantDetailsBinding
import com.example.plantector.model.Plant
import com.example.plantector.viewmodel.PlantDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailsFragment(private val plant: Plant) : Fragment() {
    private val plantDetailsViewModel: PlantDetailsViewModel by viewModels()
    private var _binding: FragmentPlantDetailsBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance(plant: Plant) = PlantDetailsFragment(plant)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlantDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailsIv.setImageResource(plant.img_dir)
        binding.detailsToolbar.title = plant.name
        binding.descriptionTv.text = plantDetailsViewModel.getPlantDescription(plant.name)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}