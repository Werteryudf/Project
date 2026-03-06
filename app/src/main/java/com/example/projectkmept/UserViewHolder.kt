package com.example.projectkmept

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
    val authorName: TextView = itemView.findViewById(R.id.authorName)
    val foodImageView: ImageView = itemView.findViewById(R.id.foodImageView)
    val foodTitle: TextView = itemView.findViewById(R.id.foodTitle)
    val foodDetails: TextView = itemView.findViewById(R.id.foodDetails)
}