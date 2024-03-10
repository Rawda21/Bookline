package com.example.bookline.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
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
                Promotions()
//                Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = SpaceBetween
//                ) {
//                    options.forEach {
//                        SelectOptions(title = it, selected = it == selected) {
//                            selected = it
//                        }
//                    }
//                }

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
                .padding(vertical = 20.dp).
                background(Color.Transparent)
    ) {
        Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue), contentAlignment = Center
        ) {
            Row(
                    modifier = Modifier.padding(vertical = 10.dp)
            ) {

                Text(text = "Bookline",
                     style = TextStyle(fontSize = 40.sp,
                                       fontFamily = FontFamily.Serif),
                     color = Color.White)
            }
        }
    }
}

//@Composable
//fun SelectOptions(
//    title: String,
//    selected: Boolean,
//    onValueChange: (String) -> Unit
//) {
//
//    Card(
//            shape = RoundedCornerShape(18.27.dp),
//            border = if (selected) BorderStroke(2.74.dp, Color.Blue) else
//                BorderStroke(
//                        0.dp,
//                        Color.Transparent
//                ),
//            modifier = Modifier
//                .width(155.dp)
//                .height(56.dp).
//                background(Color.Transparent)
//    ) {
//        Box(
//                modifier = Modifier
//                    .background(Color.White)
//                    .clickable {onValueChange(title)},
//                contentAlignment = Center
//        ) {
//            Text(
//                    text = title,
//                    style = TextStyle(
//                            color = if (selected) Color.Blue else Color.Blue,
//                            fontSize = if (selected) 19.67.sp else 18.55.sp,
//                            fontWeight = if (selected) FontWeight.W700 else FontWeight.W300,
//                            fontFamily = FontFamily.SansSerif
//                    )
//            )
//        }
//    }
//}