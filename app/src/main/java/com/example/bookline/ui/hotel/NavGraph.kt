package com.example.bookline.ui.hotel

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun setupNavgraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home" ){
        composable(route = Screen.home.route){
            showhotelScreen(navController = navController)
        }
        composable(route = Screen.popular.route){
            showhotelPopular(navController = navController)
        }
        composable(route = Screen.recomended.route){
            showhotelrecomended(navController=navController)
        }
    }
}