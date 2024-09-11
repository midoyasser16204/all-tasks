package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityRegisterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.name.edittext.hint="Enter your name"
        binding.email.edittext.hint="Enter your email"
        binding.password.edittext.hint="Enter your password"
        binding.phone.edittext.hint="Enter your phone"
        binding.loginButton.setOnClickListener {
            val nameInput = binding.name.edittext.text.toString()
            val phoneInput = binding.phone.edittext.text.toString()
            val emailInput = binding.email.edittext.text.toString()
            val passwordInput = binding.password.edittext.text.toString()
            val emailRegex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+\$".toRegex()
            val numberRegex = "^[^0-9]*\$".toRegex()
            var isValid = true
            if (nameInput.isEmpty()) {
                binding.name.edittext.error = "Name cannot empty"
                isValid = false
            }
            else if (!nameInput.matches(numberRegex)) {
                binding.name.edittext.error = "Name cannot contain numbers"
                isValid = false
            }
            else {
                binding.name.edittext.error = null
            }
            if (phoneInput.isEmpty()){
                binding.phone.edittext.error = "Phone cannot empty"
                isValid = false
            }
            else if (phoneInput.matches(numberRegex)) {
                binding.phone.edittext.error = "Phone cannot contain chars"
                isValid = false
            }
            else {
                binding.phone.edittext.error = null
            }
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