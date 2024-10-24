package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharePreferences = this.getSharedPreferences("values", Context.MODE_PRIVATE)
        val value = sharePreferences.getString("value", "")
        binding.textValue.setText(value)

        binding.buttonSave.setOnClickListener({
            val valueOnSave = binding.editValue.text.toString()
            binding.textValue.setText(valueOnSave)

            val editing = sharePreferences.edit()
            editing.putString("value", valueOnSave)
            editing.apply()
        })
    }
}