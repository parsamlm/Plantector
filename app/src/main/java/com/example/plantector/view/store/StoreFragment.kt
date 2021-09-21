package com.example.plantector.view.store

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.plantector.util.Helper
import com.example.plantector.R
import com.example.plantector.databinding.FragmentStoreBinding
import com.example.plantector.view.settings.SettingsActivity
import com.example.plantector.viewmodel.StoreViewModel

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null

    companion object {
        fun newInstance() = StoreFragment()
    }

    private val binding get() = _binding!!

    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.dateStoreTv.text = Helper.getDate()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.settings_home_iv).setOnClickListener {
            startActivity(Intent(activity, SettingsActivity()::class.java))
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}