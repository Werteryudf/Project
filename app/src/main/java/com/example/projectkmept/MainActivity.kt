package com.example.projectkmept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectkmept.romaniuc.UsersAdapter
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        val tab1: View = findViewById(R.id.tab1)
        val tab2: View = findViewById(R.id.tab2)
        val tab3: View = findViewById(R.id.tab3)
        val tab4: View = findViewById(R.id.tab4)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RecipesFragment())
                .commit()
            selectTab(tab1)
        }

        // Tab 1 - Grid
        tab1.setOnClickListener {
            selectTab(tab1)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RecipesFragment())
                .commit()
        }

        // Tab 2
        tab2.setOnClickListener {
            selectTab(tab2)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Screen2Fragment())
                .commit()
        }

        // Tab 3
        tab3.setOnClickListener {
            selectTab(tab3)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Screen3Fragment())
                .commit()
        }

        // Tab 4
        tab4.setOnClickListener {
            selectTab(tab4)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Screen4Fragment())
                .commit()
        }
    }

    private fun selectTab(selectedTab: View) {
        val tab1: TextView = findViewById(R.id.tab1)
        val tab2: TextView = findViewById(R.id.tab2)
        val tab3: TextView = findViewById(R.id.tab3)
        val tab4: TextView = findViewById(R.id.tab4)


        setTabDrawable(tab1, R.drawable.home)
        setTabDrawable(tab2, R.drawable.edit)
        setTabDrawable(tab3, R.drawable.notification)
        setTabDrawable(tab4, R.drawable.profile)

        tab1.setTextColor(android.graphics.Color.parseColor("#999999"))
        tab2.setTextColor(android.graphics.Color.parseColor("#999999"))
        tab3.setTextColor(android.graphics.Color.parseColor("#999999"))
        tab4.setTextColor(android.graphics.Color.parseColor("#999999"))



        when (selectedTab.id) {
            R.id.tab1 -> {
                setTabDrawable(tab1, R.drawable.home_green)
                tab1.setTextColor(android.graphics.Color.parseColor("#4CAF50"))
            }
            R.id.tab2 -> {
                setTabDrawable(tab2, R.drawable.edit_green)
                tab2.setTextColor(android.graphics.Color.parseColor("#4CAF50"))
            }
            R.id.tab3 -> {
                setTabDrawable(tab3, R.drawable.notification_green)
                tab3.setTextColor(android.graphics.Color.parseColor("#4CAF50"))
            }
            R.id.tab4 -> {
                setTabDrawable(tab4, R.drawable.profile_green)
                tab4.setTextColor(android.graphics.Color.parseColor("#4CAF50"))
            }
        }


    }

    private fun setTabDrawable(textView: TextView, drawableRes: Int) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, drawableRes, 0, 0)
    }

    class RecipesFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? = inflater.inflate(R.layout.activity_romaniuc, container, false)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            val foodList = listOf(
                UsersAdapter.User("Calum Lewis", "Pancake", "Food", ">60 mins",
                    "https://i.pinimg.com/1200x/1e/8c/1b/1e8c1b22db390ac5c59782692b777d40.jpg",
                    "https://www.liway.ru/upload/medialibrary/036/0367b3565bda6a8a0dac3fabc48e9835.jpg"),
                UsersAdapter.User("Eilif Sonas", "Salad", "Food", ">60 mins",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRya24a3K3d4sudzJelCcp7AHB3UANTpPBGQg&s",
                    "https://www.bahroma1.ru/goods/img-articles/kak-pravilno-fotografirovat.jpg"),
                UsersAdapter.User("Elena Shelby", "Pancake", "Food", ">60 mins",
                    "https://sun1-95.userapi.com/impg/-kJZBISahLLGK0KtZ1udOkOnmrwsmsXzn8m17w/UixIKsfwVkY.jpg?size=520x0&quality=95&sign=cf3f88e05fcd7ddf1ec82bfae46d0a57",
                    "https://cafebrynza.ru/images/articles/5-poleznykh-svojstv-goryachej-edy_66a272bd082bc2.png"),
                UsersAdapter.User("John Priyadi", "Salad", "Food", ">60 mins",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD2QcBlCrplSFxOw6t_S5hiCutqX-hhVRE1A&s",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVOmgjq7TsKh5LAoRZQMTvNSrIuBeqTDXanA&s"),
                UsersAdapter.User("Maria Garcia", "Pizza", "Food", ">45 mins",
                    "https://i.pinimg.com/1200x/1e/8c/1b/1e8c1b22db390ac5c59782692b777d40.jpg",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVOmgjq7TsKh5LAoRZQMTvNSrIuBeqTDXanA&s"),
                UsersAdapter.User("Alex Chen", "Sushi", "Food", ">90 mins",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD2QcBlCrplSFxOw6t_S5hiCutqX-hhVRE1A&s",
                    "https://www.liway.ru/upload/medialibrary/036/0367b3565bda6a8a0dac3fabc48e9835.jpg"),
                UsersAdapter.User("Sofia Rossi", "Pasta", "Food", ">30 mins",
                    "https://i.pinimg.com/1200x/1e/8c/1b/1e8c1b22db390ac5c59782692b777d40.jpg",
                    "https://www.liway.ru/upload/medialibrary/036/0367b3565bda6a8a0dac3fabc48e9835.jpg"),
                UsersAdapter.User("Marco Bello", "Risotto", "Food", ">50 mins",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD2QcBlCrplSFxOw6t_S5hiCutqX-hhVRE1A&s",
                    "https://cafebrynza.ru/images/articles/5-poleznykh-svojstv-goryachej-edy_66a272bd082bc2.png")
            )

            // Создаём адаптер с lambda функцией для обработки клика
            val adapter = UsersAdapter(foodList) { user ->
                // При клике открываем детальный экран рецепта
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, RecipeDetailFragment.newInstance(user))
                    .addToBackStack(null)
                    .commit()
            }

            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    class Screen2Fragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? = inflater.inflate(R.layout.scr2, container, false)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        }
    }


    class Screen3Fragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? = inflater.inflate(R.layout.scr3, container, false)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            // Здесь добавляй логику для третьего экрана
        }
    }


    class Screen4Fragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? = inflater.inflate(R.layout.scr4, container, false)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        }
    }
}