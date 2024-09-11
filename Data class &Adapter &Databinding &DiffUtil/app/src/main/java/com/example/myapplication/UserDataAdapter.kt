package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutOneBinding
import com.example.myapplication.databinding.ItemLayoutTwoBinding

class UserDataAdapter(
    val onItemDeleted:(Pair<UserData,Int>)->Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val userlist: MutableList<UserData> = mutableListOf()

    fun setUserList(list: List<UserData>) {
        val myDiffUtil=MyDiffUtil(userlist,list)
        val diffResult=DiffUtil.calculateDiff(myDiffUtil)
        userlist.clear()
        userlist.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    companion object {
        private const val holder_type_one = 1
        private const val holder_type_two = 2
    }

    inner class ViewHolderOne(val binding: ItemLayoutOneBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(userData: UserData) {
            binding.user = userData
            binding.delete.setOnClickListener{
                onItemDeleted(Pair(userData,adapterPosition))
            }
        }
    }

    inner class ViewHolderTwo(val binding: ItemLayoutTwoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(userData: UserData) {
            binding.user = userData
            binding.delete.setOnClickListener{
                onItemDeleted(Pair(userData,adapterPosition))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (userlist[position].type) {
            1 -> holder_type_one
            2 -> holder_type_two
            else -> holder_type_one
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            holder_type_one -> {
                val binding = ItemLayoutOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderOne(binding)
            }
            holder_type_two -> {
                val binding = ItemLayoutTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderTwo(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            holder_type_one -> (holder as ViewHolderOne).bindData(userlist[position])
            holder_type_two -> (holder as ViewHolderTwo).bindData(userlist[position])
        }
    }

    override fun getItemCount() = userlist.size
}
