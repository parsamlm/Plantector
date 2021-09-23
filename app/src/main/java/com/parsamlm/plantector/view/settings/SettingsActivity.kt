package com.parsamlm.plantector.view.settings

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import com.parsamlm.plantector.R
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val darkModeSwitch: SwitchMaterial = findViewById(R.id.dark_mode_switch_settings)
        val sharedPreferences:SharedPreferences = getSharedPreferences("PlantectorPref", MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        findViewById<ImageView>(R.id.back_btn_settings).setOnClickListener{
            finish()
        }

        darkModeSwitch.isChecked = sharedPreferences.getBoolean("isDarkModeEnabled", false)


        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            sharedPrefEditor.putBoolean("isDarkModeEnabled", isChecked).apply()
        }




    }
}