package com.example.bookline.ui.hotel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun showhotelScreen(navController: NavHostController){

    lateinit var navController: NavHostController
    navController = rememberNavController()

    setupNavgraph(navController = navController)

    var search by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                HotelMenu(text = search, onValueChange = { search = it })
                Row(modifier = Modifier.padding(start = 20.dp)) {
                    Button(onClick = { navController.navigate(route = "popular") }) {
                        Text(text = "Popular")
                    }
                    Spacer(modifier = Modifier.padding(3.dp))
                    Button(onClick = { navController.navigate(route = "recomended") }) {
                        Text(text = "Popular")
                    }
                    Spacer(modifier = Modifier.padding(3.dp))
                    Button(onClick = { navController.navigate(route = "popular") }) {
                        Text(text = "Popular")
                    }
                }

                showhotel()
            }
        }
    }
}