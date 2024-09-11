package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.email.edittext.hint="Enter your email"
        binding.password.edittext.hint="Enter your password"
        binding.loginButton.setOnClickListener {
            var emailInput = binding.email.edittext.text.toString()
            var passwordInput = binding.password.edittext.text.toString()
            var emailCheck = intent.getStringExtra("email")
            var passwordCheck = intent.getStringExtra("password")
            val emailRegex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+\$".toRegex()
            var isValid = true
            if (emailInput.isEmpty()){
                binding.email.edittext.error = "Email cannot empty"
                isValid = false
            }
            else if (!emailInput.matches(emailRegex)) {
                binding.email.edittext.error = "Invalid email address"
                isValid = false
            }
            else {
                binding.email.edittext.error = null
            }
            if (passwordInput.isEmpty()){
                binding.password.edittext.error = "Password cannot empty"
                isValid = false
            }
            else if (passwordInput.length < 15) {
                binding.password.edittext.error = "Password must be at least 15 characters"
                isValid = false
            }
            else {
                binding.password.edittext.error = null
            }
            if (isValid) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            }
        }
        binding.Return.setOnClickListener() {
            val in1 = Intent(this,MainActivity::class.java)
            startActivity(in1)
        }
    }
}