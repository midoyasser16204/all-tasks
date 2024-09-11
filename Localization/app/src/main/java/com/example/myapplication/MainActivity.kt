package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.textclassifier.TextLanguage
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.text.setOnClickListener{
            setLocalization(this,"ar")
        }
    }
    fun setLocalization(context: Context,languageCode: String){
        val local = Locale(languageCode)
        Locale.setDefault(local)
        val res = context.resources
        val config = resources.configuration
        config.setLocale(local)
        res.updateConfiguration(config,res.displayMetrics)
        recreate()
    }
}