package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    lateinit var binding: FragmentTwoBinding
    lateinit var name: String
    lateinit var email: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTwoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name=arguments?.getString("name","").toString()
        email=arguments?.getString("email","").toString()
        binding.t1.text = name
        binding.t2.text = email
    }
}