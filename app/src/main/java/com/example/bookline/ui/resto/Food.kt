package com.example.bookline.ui.resto

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookline.R

data class Food(
    val id:Int,
    val title:String,
    @DrawableRes val image:Int,
    val price:String
)

val foodList = listOf(
        Food(1, "PopCorn 2x1", R.drawable.popcorn, "$3,99"),
        Food(2,"Burger and fries",R.drawable.burger,"$7,99"),
        Food(3,"Chicken wings",R.drawable.chicken,"$60,99"),
        Food(4,"PopCorn 2x1",R.drawable.popcorn,"$3,99")
)
@Composable
fun showrestaurant() {
    run {
        val imageId = arrayOf(
            R.drawable.burger,
            R.drawable.chicken,
            R.drawable.popcorn,
            R.drawable.chicken,
            R.drawable.popcorn,
            R.drawable.burger
        )

        val names = arrayOf(
            "Peperoni",
            "Vegan",
            "FourCheese",
            "Margaritta",
            "American",
            "Mexican"
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
                MainScreen(imageId, names, ingredients, navController)
            }
            composable(route = "DetailScreen/{index}",
                arguments = listOf(
                    navArgument(name = "index") {
                        type = NavType.IntType
                    }
                )
            ) { index ->
                DetailScreen(
                    photos = imageId,
                    names = names,
                    ingredients = ingredients,
                    itemIndex = index.arguments?.getInt("index")
                )
            }
        }

    }
}