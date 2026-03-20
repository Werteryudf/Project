package com.example.projectkmept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectkmept.romaniuc.UsersAdapter

class RecipeDetailFragment : Fragment() {

    private val recipeDatabase = mapOf(
        "Pancake" to Pair(
            listOf("4 Eggs", "1/2 Cup Butter", "2 Cups Flour", "1 Cup Milk"),
            listOf(
                "Mix eggs and butter in a large bowl until smooth and creamy",
                "Add flour gradually while stirring to avoid lumps",
                "Pour batter on heated pan and cook for 2-3 minutes per side"
            )
        ),
        "Salad" to Pair(
            listOf("2 Tomatoes", "1 Cucumber", "100g Lettuce", "Olive Oil"),
            listOf(
                "Wash all vegetables thoroughly under cold water",
                "Chop tomatoes and cucumber into bite-sized pieces",
                "Mix everything in bowl and drizzle with olive oil"
            )
        ),
        "Pizza" to Pair(
            listOf("Pizza Dough", "200g Cheese", "Tomato Sauce", "Pepperoni"),
            listOf(
                "Roll out the pizza dough into a circle on floured surface",
                "Spread tomato sauce evenly and add cheese and toppings",
                "Bake in preheated oven at 220°C for 12-15 minutes"
            )
        ),
        "Sushi" to Pair(
            listOf("Sushi Rice", "Nori Sheets", "Fresh Salmon", "Cucumber"),
            listOf(
                "Cook sushi rice and let it cool to room temperature",
                "Place nori on bamboo mat and spread rice evenly",
                "Add salmon and cucumber, roll tightly and slice"
            )
        ),
        "Pasta" to Pair(
            listOf("500g Pasta", "Tomato Sauce", "Parmesan", "Basil"),
            listOf(
                "Boil water with salt and cook pasta for 8-10 minutes",
                "Heat tomato sauce in a separate pan with herbs",
                "Drain pasta, mix with sauce and top with parmesan"
            )
        ),
        "Risotto" to Pair(
            listOf("Arborio Rice", "Chicken Stock", "Mushrooms", "White Wine"),
            listOf(
                "Sauté rice in butter until slightly translucent",
                "Add wine and stock gradually while stirring constantly",
                "Add mushrooms and cook until rice is creamy and tender"
            )
        )
    )

    companion object {
        fun newInstance(user: UsersAdapter.User): RecipeDetailFragment {
            return RecipeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString("authorName", user.authorName)
                    putString("foodTitle", user.foodTitle)
                    putString("category", user.category)
                    putString("cookingTime", user.cookingTime)
                    putString("avatarUrl", user.avatarUrl)
                    putString("foodImageUrl", user.foodImageUrl)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_recipe_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.detailRecyclerView)
        val foodImage: ImageView = view.findViewById(R.id.foodImage)
        val backButton: ImageButton = view.findViewById(R.id.backButton)

        recyclerView.isNestedScrollingEnabled = false
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val args = arguments ?: return
        val title        = args.getString("foodTitle", "Pancake")
        val authorName   = args.getString("authorName", "")
        val category     = args.getString("category", "Food")
        val cookingTime  = args.getString("cookingTime", "")
        val avatarUrl    = args.getString("avatarUrl", "")
        val foodImageUrl = args.getString("foodImageUrl", "")

        Glide.with(requireContext())
            .load(foodImageUrl)
            .centerCrop()
            .into(foodImage)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val (ingredients, steps) = recipeDatabase[title] ?: recipeDatabase["Pancake"]!!

        val items: MutableList<Item> = mutableListOf(
            InfoItem(
                name = title,
                description = "Your recipe for $title has been uploaded. You can see it on your profile. Your recipe has been uploaded, you can see it on your",
                category = category,
                cookingTime = cookingTime,
                avatarUrl = avatarUrl,
                authorName = authorName,
                foodImageUrl = foodImageUrl,
                likes = 273,
                isLiked = false
            ),
            SectionTitleItem("Ingredients")
        )

        for (ing in ingredients) {
            items.add(IngredientItem(ing))
        }

        items.add(SectionTitleItem("Steps"))
        steps.forEachIndexed { index, instruction ->
            val imageUrl = if (index % 2 == 0) foodImageUrl else ""
            items.add(StepItem(index + 1, instruction, imageUrl))
        }

        recyclerView.adapter = RecipeDetailAdapter(items) {
            parentFragmentManager.popBackStack()
        }
        Glide.with(requireContext())
            .load(foodImageUrl)
            .centerCrop()
            .override(1080, 1920)  // ← принудительно высокое разрешение
            .into(foodImage)
    }

}