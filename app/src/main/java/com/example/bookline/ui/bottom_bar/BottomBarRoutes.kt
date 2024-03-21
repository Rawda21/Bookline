package com.example.bookline.ui.bottom_bar

import com.example.bookline.R

sealed class BottomBarRoutes(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
    )
{
    object Home_screen: BottomBarRoutes(
            route = "homeScreen",
            title = "Home",
            icon = R.drawable.home,
            icon_focused = R.drawable.home
    )

    object Taxi_screen: BottomBarRoutes(
        route = "taxiScreen",
        title = "Taxi",
        icon = R.drawable.taxi,
        icon_focused = R.drawable.taxi
)

    object Hotel_screen: BottomBarRoutes(
            route = "HotelScreen",
            title = "Hotel",
            icon = R.drawable.hotel,
            icon_focused = R.drawable.hotel
    )

    object Food_screen: BottomBarRoutes(
            route = "RestaurantScreen",
            title = "Restaurant",
            icon = R.drawable.restaurant,
            icon_focused = R.drawable.restaurant
    )

    object Clinic_screen: BottomBarRoutes(
            route = "ClinicScreen",
            title = "Clinic",
            icon = R.drawable.hospital,
            icon_focused = R.drawable.hospital
    )
}
