package com.example.projectkmept

open class Item

class InfoItem(
    var name: String,
    var description: String,
    val category: String,
    val cookingTime: String,
    val avatarUrl: String,
    val authorName: String,
    val foodImageUrl: String,
    var likes: Int,
    var isLiked: Boolean
) : Item()

class SectionTitleItem(val title: String) : Item()

class IngredientItem(val name: String, var isChecked: Boolean = false) : Item()

class StepItem(val number: Int, val instruction: String, val imageUrl: String = "") : Item()
