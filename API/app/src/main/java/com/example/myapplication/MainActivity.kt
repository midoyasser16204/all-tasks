package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.textclassifier.TextLanguage
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var viewModule: AlbumViewModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val albumAdapter = AlbumAdapter(mutableListOf())
        binding.albumList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = albumAdapter
        }
        viewModule = ViewModelProvider(this).get(AlbumViewModule::class.java)
        viewModule.album.observe(this, Observer { albumList ->
            albumAdapter.updateData(albumList)
        })
    }
}
