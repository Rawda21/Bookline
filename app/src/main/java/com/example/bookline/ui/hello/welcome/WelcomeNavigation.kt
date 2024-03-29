package com.example.bookline.ui.hello.welcome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object WelcomeNavigation {
    const val route = "welcome"
}

fun NavGraphBuilder.welcomeRoute(
    onNavigateFurther: () -> Unit
) {
    composable(
        route = WelcomeNavigation.route,
    ) {
        WelcomeScreen(onNavigateFurther = onNavigateFurther)
    }
}
