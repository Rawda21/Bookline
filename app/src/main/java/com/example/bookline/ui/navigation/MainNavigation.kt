package com.example.bookline.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookline.ui.bottom_bar.BottomBarRoutes
import com.example.bookline.ui.clinic.ClinicScreen
import com.example.bookline.ui.home.HomeScreen
import com.example.bookline.ui.hotel.HotelScreen
import com.example.bookline.ui.resto.FoodScreen
import com.example.bookline.ui.taxi.TaxiScreen

@Composable
fun MainNavigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = BottomBarRoutes.Home_screen.route) {
        composable(BottomBarRoutes.Home_screen.route) {
            HomeScreen()
        }
        composable(BottomBarRoutes.Taxi_screen.route) {
            TaxiScreen()
        }
        composable(BottomBarRoutes.Hotel_screen.route) {
            HotelScreen()
        }
        composable(BottomBarRoutes.Food_screen.route) {
            FoodScreen()
        }
        composable(BottomBarRoutes.Clinic_screen.route) {
            ClinicScreen()
        }
    }

}