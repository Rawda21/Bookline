package com.example.bookline.ui.hotel

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookline.R

@Composable
fun showhotelrecomended(navController : NavController) {
    run {
        val imageId = arrayOf(
            R.drawable.hotel1,
            R.drawable.hotel2,
            R.drawable.hotel3,
            R.drawable.hotel1,
            R.drawable.hotel2,
            R.drawable.hotel3
        )

        val names = arrayOf(
            "Helton",
            "Almasa",
            "Rixsos",
            "Safari",
            "Sunrise",
            "Ebrotel"
        )

        val ingredients = arrayOf(
            "Tomato sos, cheese, oregano, peperoni",
            "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
            "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
            "Tomato sos, cheese, oregano, bazillion",
            "Tomato sos, cheese, oregano, green paprika, red beans",
            "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
        )

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "MainScreen") {
            composable(route = "MainScreen") {
                com.example.bookline.ui.resto.MainScreen(imageId, names, ingredients, navController)
            }
            composable(route = "DetailScreen/{index}",
                arguments = listOf(
                    navArgument(name = "index") {
                        type = NavType.IntType
                    }
                )
            ) { index ->
                com.example.bookline.ui.resto.DetailScreen(
                    photos = imageId,
                    names = names,
                    ingredients = ingredients,
                    itemIndex = index.arguments?.getInt("index")
                )
            }
        }

    }
}
