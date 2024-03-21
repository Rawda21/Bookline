package com.example.bookline.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookline.design.Navbar


@Composable
fun HomeScreen() {

    val options = listOf("Sign Up", "Login")
    var selected by remember { mutableStateOf("") }

    Box(
            modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
        ) {
            Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp, top = 40.dp)
            ) {
                LogoIcon()
                Promotions()

                LazyRow {
                    items(moviesList) {
                        MoviesEachRow(movies = it)
                    }
                }
            }
        }
    }
}

@Composable
fun MoviesEachRow(
    movies: Movies
) {

    Column(
            modifier = Modifier.padding(
                    top = 20.dp, end = 20.dp,
            ),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
                painter = painterResource(id = movies.poster), contentDescription = "",
                modifier = Modifier
                    .width(217.dp)
                    .height(310.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
        )
        Text(
                text = movies.movieName,
                style = TextStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(140.dp)
        )
    }
}
@Composable
fun Promotions() {
    Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
    ) {
        Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
        ) {
            Row(
                    modifier = Modifier.padding(vertical = 2.dp)
            ) {

                Text(text = "Bookline",
                     style = TextStyle(fontSize = 40.sp,
                                       fontFamily = FontFamily.Serif),
                     color = Color.Blue)
            }
        }
    }
}
