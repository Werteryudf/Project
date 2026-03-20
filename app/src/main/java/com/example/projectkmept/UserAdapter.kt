package com.example.projectkmept.romaniuc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectkmept.R
import com.example.projectkmept.UserViewHolder
class UsersAdapter(
    private val userList: List<User>,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserViewHolder>() {

    data class User(
        val authorName: String,
        val foodTitle: String,
        val category: String,
        val cookingTime: String,
        val avatarUrl: String,
        val foodImageUrl: String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.food, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.authorName.text = currentUser.authorName
        holder.foodTitle.text = currentUser.foodTitle
        holder.foodDetails.text = "${currentUser.category}  •  ${currentUser.cookingTime}"

        Glide.with(holder.itemView.context)
            .load(currentUser.avatarUrl)
            .circleCrop()
            .into(holder.avatarImageView)

        Glide.with(holder.itemView.context)
            .load(currentUser.foodImageUrl)
            .centerCrop()
            .override(1080, 1080)  // ← добавь эту строку
            .into(holder.foodImageView)

        // Клик по карточке
        holder.itemView.setOnClickListener {
            onItemClick(currentUser)
        }
    }

    override fun getItemCount(): Int = userList.size
}