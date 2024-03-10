package com.example.bookline.ui.hotel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookline.ui.home.Movies
import com.example.bookline.ui.home.moviesList

@Preview
@Composable
fun HotelScreen() {

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

                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(moviesList) {
                        ComingSoonMovieRow(it)
                    }
                }
            }
        }
    }

}

@Composable
fun ComingSoonMovieRow(
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
                    .width(154.dp)
                    .height(220.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
        )
        Text(
                text = movies.movieName,
                style = TextStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(140.dp)
        )
    }
}