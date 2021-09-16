package com.example.plantector.ui.store

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.plantector.R
import com.example.plantector.ui.settings.SettingsActivity

class StoreFragment : Fragment() {

    companion object {
        fun newInstance() = StoreFragment()
    }

    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
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