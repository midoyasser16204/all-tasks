package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val userDatalist: MutableList<UserData> = mutableListOf()
    private lateinit var userAdapter: UserDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        addtollist()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        userAdapter = UserDataAdapter(){
            userDatalist.remove(it.first)
            userAdapter.setUserList(userDatalist)
            userAdapter.notifyItemRemoved(it.second)
        }
        userAdapter.setUserList(userDatalist)
        binding.list.adapter = userAdapter
        binding.update.setOnClickListener{
            updatellist()
            userAdapter.setUserList(userDatalist)
        }
    }

    private fun addtollist() {
        userDatalist.clear()
        userDatalist.add(UserData(1, 1, "Ahmed", "ahmed@gmail.com", "0123456789"))
        userDatalist.add(UserData(2, 2, "Mohamed", "mohamed@gmail.com", "0123456789"))
        userDatalist.add(UserData(3, 1, "Hassan", "hassan@gmail.com", "0123456789"))
        userDatalist.add(UserData(4, 2, "Ali", "ali@gmail.com", "0123456789"))
        userDatalist.add(UserData(5, 1, "Yara", "yara@gmail.com", "0123456789"))
    }
    private fun updatellist() {
        userDatalist.clear()
        userDatalist.add(UserData(1, 1, "A", "ahmed@gmail.com", "0123456789"))
        userDatalist.add(UserData(2, 2, "M", "mohamed@gmail.com", "0123456789"))
        userDatalist.add(UserData(3, 1, "Hassan", "hassan@gmail.com", "0123456789"))
        userDatalist.add(UserData(4, 2, "Ali", "ali@gmail.com", "0123456789"))
        userDatalist.add(UserData(5, 1, "Yara", "yara@gmail.com", "0123456789"))
    }
}
