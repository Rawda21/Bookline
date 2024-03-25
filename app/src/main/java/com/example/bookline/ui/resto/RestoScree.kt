package com.example.bookline.ui.resto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.bookline.R

@Preview
@Composable
fun FoodScreen() {

    var search by remember { mutableStateOf("") }
    val menuList = listOf("Promotion", "Drinks", "Fast food")
    val scrollState = rememberScrollState()
    var currentMenuState by remember { mutableStateOf("Promotion") }

    Box(
            modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
        ) {
            Column {
                FoodHeader()
                FoodMenu(text = search, onValueChange = { search = it })
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
                showrestaurant()
            }

        }
    }
}

@Composable
fun ShowFood(
    food: Food
) {
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 15.dp, end = 30.dp, start = 30.dp
                )
                .clip(RoundedCornerShape(13.dp))
                .background(Color.White)
    ) {
        Row(
                modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                    painter = painterResource(id = food.image), contentDescription = "",
                    modifier = Modifier
                        .width(150.dp)
                        .fillMaxHeight()
                        .weight(0.5f)
            )
            Column(
                    modifier = Modifier.padding(15.dp)
            ) {
                Text(
                        text = food.title, style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.W800,
                        color = Color.Blue,
                        fontFamily = FontFamily.Serif
                )
                )
                Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                            text = food.price, style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.W300,
                            color = Color.Blue,
                            fontFamily = FontFamily.Serif
                    )
                    )
                    TextButton(
                            onClick = { },
                            shape = RoundedCornerShape(4.dp),
//                            colors = ButtonDefaults.buttonColors(
//                                    color = Color.White
//                            ),
                            modifier = Modifier
                                .size(31.dp)
                                .align(Alignment.CenterVertically)
                    ) {
                        Icon(
                                Icons.Default.Add,
                                contentDescription = "",
                                tint = Color.Black,
                                modifier = Modifier.size(
                                        20.dp
                                )
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CustomFoodChip(
    title: String,
    selected: Boolean,
    onValueChange: (String) -> Unit
) {
    TextButton(
            onClick = {
                onValueChange(title)
            },
//            colors = ButtonDefaults.buttonColors(
//                    background = if (selected) Color.Blue else Color.LightGray
//            ),
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier
                .padding(end = 10.dp)
                .background(if (selected) Color.Blue else Color.LightGray)
    ) {
        Text(
                text = title, style = TextStyle(
                color = Color.White,
                fontFamily = FontFamily.Serif,
                fontSize = 13.sp,
                fontWeight = FontWeight.W500
        )
        )
    }
}

@Composable
fun FoodMenu(
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
                text = stringResource(R.string.menu),
                style = TextStyle(
                        fontSize = 27.sp,
                        fontWeight = FontWeight.W800,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue
                ),
        )
        CustomSearchView(text = text, onValueChange = { onValueChange(it) })
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
fun FoodHeader() {
    Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {}
        Text(
                text = stringResource(R.string.FOOD), style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.W800,
                fontFamily = FontFamily.Serif,
                color = Color.Blue
        ),
                modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
@Composable
fun Fooader() {}