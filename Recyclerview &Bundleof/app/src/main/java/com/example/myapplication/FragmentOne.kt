package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    lateinit var name:String
    lateinit var email:String
    lateinit var binding: FragmentOneBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.doAfterTextChanged {
            name = binding.name.text.toString()
        }
        binding.email.doAfterTextChanged {
            email = binding.email.text.toString()
        }
        binding.button.setOnClickListener{
            findNavController().navigate(R.id.fragmentTwo, bundleOf(
                "name" to name,
                "email" to email
            ))
        }
    }
}