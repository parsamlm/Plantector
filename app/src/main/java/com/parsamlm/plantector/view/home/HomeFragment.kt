package com.parsamlm.plantector.view.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.parsamlm.plantector.util.Helper
import com.parsamlm.plantector.R
import com.parsamlm.plantector.databinding.FragmentHomeBinding
import com.parsamlm.plantector.model.Plant
import com.parsamlm.plantector.view.plant.details.PlantDetailsFragment
import com.parsamlm.plantector.view.settings.SettingsActivity
import com.parsamlm.plantector.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), PlantAdapter.OnPlantItemClicked {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private lateinit var plantAdapter: PlantAdapter
    lateinit var fragmentTransaction: FragmentTransaction

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentTransaction = parentFragmentManager.beginTransaction()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val plantList = homeViewModel.getPlantList()
        plantAdapter = PlantAdapter(root.context, this, plantList)
        binding.homeRv.adapter = plantAdapter
        binding.homeRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.dateHomeTv.text = Helper.getTodayDate()

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settingsHomeIv.setOnClickListener {
            startActivity(Intent(activity, SettingsActivity()::class.java))
        }

        binding.searchBoxEtHome.addTextChangedListener {
            plantAdapter.filter(it.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMoreInfoButtonClicked(plant: Plant) {
        fragmentTransaction.replace(
            R.id.nav_host_fragment_activity_main,
            PlantDetailsFragment.newInstance(plant)
        )
            .addToBackStack("Fragment_PlantDetails").commit()
    }
}