package com.example.plantector.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cesarferreira.tempo.Tempo
import com.cesarferreira.tempo.beginningOfDay
import com.cesarferreira.tempo.removeHours
import com.example.plantector.R
import com.example.plantector.databinding.FragmentHomeBinding
import com.example.plantector.model.Plant
import com.example.plantector.model.PlantList
import com.example.plantector.ui.settings.SettingsActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var plantAdapter: PlantAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val date = Tempo.now.toString().subSequence(0, 9).toString() + "," + Tempo.now.toString()
            .subSequence(29, Tempo.now.toString().length).toString()

        binding.dateHomeTv.text = date

        val plantList = PlantList.makeDefaultFlowerList()
        plantAdapter = PlantAdapter(root.context, plantList)
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
}