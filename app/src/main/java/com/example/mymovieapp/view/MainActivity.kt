package com.example.mymovieapp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mymovieapp.R
import com.example.mymovieapp.adapters.MovieAdapter
import com.example.mymovieapp.databinding.ActivityMainBinding
import com.example.mymovieapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = MovieAdapter(mutableListOf(), viewModel)
        binding.recyclerview.adapter = adapter

    }
}