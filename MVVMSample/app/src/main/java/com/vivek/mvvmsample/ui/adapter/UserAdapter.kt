package com.vivek.mvvmsample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vivek.mvvmsample.data.models.UsersItem
import com.vivek.mvvmsample.databinding.ItemUserBinding

class UserAdapter(private val con: Context, val list: List<UsersItem>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UsersItem, con: Context) {
            with(binding) {

                //binding.model = item
//                binding.executePendingBindings()
                val strImage = item.avatarUrl
                val name = item.login
                Glide.with(con).load(strImage).into(binding.userImage);
                binding.userName.text = name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position],con)
    }


    override fun getItemCount(): Int {
        return list.size
    }
}
