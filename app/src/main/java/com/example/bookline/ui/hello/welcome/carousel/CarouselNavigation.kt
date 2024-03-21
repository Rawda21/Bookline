package com.example.bookline.ui.hello.welcome.carousel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.bookline.ui.hello.welcome.WelcomeNavigation

object CarouselNavigation {
    const val route = "carousel"
}

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.carouselRoute(
    onNavigateFurther: () -> Unit
) {
    composable(route = CarouselNavigation.route) {
        CarouselScreen(onNavigateFurther = onNavigateFurther)
    }
}

fun NavHostController.navigateToCarouselRoute() {
    navigate(CarouselNavigation.route) {
        popUpTo(WelcomeNavigation.route) {
            inclusive = true
        }
    }
}