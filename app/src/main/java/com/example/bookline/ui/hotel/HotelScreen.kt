package com.example.bookline.ui.hotel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookline.R
import com.example.bookline.ui.clinic.ClinicMenu
import com.example.bookline.ui.clinic.showclinics
import com.example.bookline.ui.home.Movies
import com.example.bookline.ui.home.moviesList
import com.example.bookline.ui.resto.FoodHeader

@Preview
@Composable
fun HotelScreen() {
    var search by remember { mutableStateOf("") }
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
            ) {

                HotelMenu(text = search, onValueChange = { search = it })
                Row(modifier = Modifier.padding(start = 20.dp)) {
                    Button(onClick = {  }) {
                        Text(text = "Recommended")
                    }
                    Spacer(modifier = Modifier.padding(3.dp))
                    Button(onClick = { }) {
                        Text(text = "Popular")
                    }
                    Spacer(modifier = Modifier.padding(3.dp))
                    Button(onClick = { }) {
                        Text(text = "Trending")

                    }

                }
                Spacer(modifier = Modifier.padding(2.dp))
                showhotel()
            }

        }
    }


}
@Composable
fun HotelMenu(
    text: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 20.dp, horizontal = 30.dp)
    ) {
        Text(
            text = stringResource(R.string.header),
            style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.W800,
                fontFamily = FontFamily.Serif,
                color = Color.Blue
            ),
        )
        Spacer(modifier = Modifier.padding(3.dp))
        com.example.bookline.ui.resto.CustomSearchView(
            text = text,
            onValueChange = { onValueChange(it) })
    }

}

/*@Composable
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
}*/
@Composable
fun showhotel() {
    run {
        val imageId = arrayOf(
            R.drawable.hotel1,
            R.drawable.hotel2,
            R.drawable.hotel3,
            R.drawable.hotel1,
            R.drawable.hotel2,
            R.drawable.hotel3
        )

        val names = arrayOf(
            "Helton",
            "Almasa",
            "Rixsos",
            "Safari",
            "Sunrise",
            "Ebrotel"
        )

        val ingredients = arrayOf(
            "Tomato sos, cheese, oregano, peperoni",
            "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
            "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
            "Tomato sos, cheese, oregano, bazillion",
            "Tomato sos, cheese, oregano, green paprika, red beans",
            "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
        )

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "MainScreen") {
            composable(route = "MainScreen") {
                com.example.bookline.ui.resto.MainScreen(imageId, names, ingredients, navController)
            }
            composable(route = "DetailScreen/{index}",
                arguments = listOf(
                    navArgument(name = "index") {
                        type = NavType.IntType
                    }
                )
            ) { index ->
                com.example.bookline.ui.resto.DetailScreen(
                    photos = imageId,
                    names = names,
                    ingredients = ingredients,
                    itemIndex = index.arguments?.getInt("index")
                )
            }
        }

    }
}


