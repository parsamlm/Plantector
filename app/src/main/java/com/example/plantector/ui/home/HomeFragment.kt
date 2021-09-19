package com.example.plantector.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.plantector.Helper
import com.example.plantector.R
import com.example.plantector.databinding.FragmentHomeBinding
import com.example.plantector.model.Plant
import com.example.plantector.ui.plant.details.PlantDetailsFragment
import com.example.plantector.ui.settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment(), PlantAdapter.OnPlantItemClicked {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var plantAdapter: PlantAdapter
    lateinit var fragmentTransaction: FragmentTransaction

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        fragmentTransaction = parentFragmentManager.beginTransaction()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.dateHomeTv.text = Helper.getDate()

        val plantList = Plant.getDefaultFlowerList()
        plantAdapter = PlantAdapter(root.context, this, plantList)
        binding.homeRv.adapter = plantAdapter
        binding.homeRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.settings_home_iv).setOnClickListener {
            startActivity(Intent(activity, SettingsActivity()::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMoreInfoButtonClicked(plant: Plant) {
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, PlantDetailsFragment.newInstance(plant))
            .addToBackStack("Fragment_PlantDetails").commit()
    }
}