package com.parsamlm.plantector.view.plant.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.parsamlm.plantector.R
import com.parsamlm.plantector.databinding.FragmentPlantDetailsBinding
import com.parsamlm.plantector.model.Plant
import com.parsamlm.plantector.util.Helper.Companion.showSnackBar
import com.parsamlm.plantector.viewmodel.PlantDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailsFragment(private val plant: Plant = Plant("Dahlia", "Asteraceae", R.drawable.dahlia)) : Fragment() {
    private val plantDetailsViewModel: PlantDetailsViewModel by viewModels()
    private var _binding: FragmentPlantDetailsBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = PlantDetailsFragment()
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
        plantDetailsViewModel.getPlantDescription(plantName = plant.name)
            .observe(viewLifecycleOwner) {
                binding.descriptionTv.text = it
            }
        plantDetailsViewModel.isErrorOccurred().observe(viewLifecycleOwner) { isOccurred ->
            if (isOccurred == true) {
                showSnackBar("No internet connection", R.color.orange_500)
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}