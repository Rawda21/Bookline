package com.example.bookline.ui.hotel

sealed class Screen(val route :String) {
    object popular:Screen(route = "popularscreen")
    object recomended:Screen(route = "recomendedscreen")

}
