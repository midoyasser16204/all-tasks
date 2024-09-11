package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel:ScoreViewModel by viewModels()
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.scoreOne.observe(this,Observer {
            binding.score1.text=it.toString()
        })
        viewModel.scoreTwo.observe(this,Observer {
            binding.score2.text=it.toString()
        })
        binding.increase1.setOnClickListener{
            viewModel.incrementTeamOneScore()
        }
        binding.increase2.setOnClickListener{
            viewModel.incrementTeamTwoScore()
        }
    }
}