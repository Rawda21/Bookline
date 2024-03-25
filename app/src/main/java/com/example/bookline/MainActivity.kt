package com.example.bookline

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bookline.ui.bottom_bar.BottomBar
import com.example.bookline.ui.home.HomeScreen
import com.example.bookline.ui.hotel.setupNavgraph
import com.example.bookline.ui.navigation.MainNavigation
import com.example.bookline.ui.theme.BooklineTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooklineTheme {
                val navHostController = rememberNavController()


                Surface{
                    Scaffold(
                            bottomBar = {
                                BottomBar(navController = navHostController)
                            }
                    ) {
                        MainNavigation(navHostController = navHostController)

                    }
                }
            }
        }
    }
}
