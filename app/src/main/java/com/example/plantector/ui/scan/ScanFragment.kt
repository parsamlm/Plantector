package com.example.plantector.ui.scan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.plantector.R
import com.example.plantector.databinding.FragmentScanBinding

class ScanFragment : Fragment() {

    private lateinit var scanViewModel: ScanViewModel
    private var _binding: FragmentScanBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: ScanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scanViewModel = ViewModelProvider(this).get(ScanViewModel::class.java)
        _binding = FragmentScanBinding.inflate(inflater, container,false)
        val root: View = binding.root

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScanViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}