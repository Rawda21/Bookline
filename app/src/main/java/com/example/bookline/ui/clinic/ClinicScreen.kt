package com.example.bookline.ui.clinic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookline.R
import com.example.bookline.ui.hotel.HotelMenu
@Preview
@Composable
fun ClinicScreen() {
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
                ClinicMenu(text = search, onValueChange = { search = it })
                Spacer(modifier = Modifier.padding(3.dp))
                showclinics()
            }

        }
    }
}
@Composable
fun ClinicMenu(
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
            text = stringResource(R.string.clinic),
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchView(
    text: String,
    onValueChange: (String) -> Unit
) {
    Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
        TextField(
            value = text, onValueChange = {
                onValueChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.White,
                textColor = Color.White
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily.Serif
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search), contentDescription = "",
                    tint = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.microphone), contentDescription = "",
                    tint = Color.White
                )
            }
        )
    }
}

@Composable
fun showclinics() {
    run {
        val imageId = arrayOf(
            R.drawable.clinic1,
            R.drawable.clinic2,
            R.drawable.clinic3,
            R.drawable.clinic4,
            R.drawable.clinic5,
            R.drawable.clinic1
        )

        val names = arrayOf(
            "Smile",
            "Shefaa",
            "Mashhour Clinic",
            "Oasis Clinic",
            "Cleopatra Clinic",
            "Royalcare Clinic"
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