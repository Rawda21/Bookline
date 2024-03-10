package com.example.bookline.ui.home

import androidx.annotation.DrawableRes
import com.example.bookline.R

data class Movies(
    val movieName:String,
    @DrawableRes val poster:Int,
    val releasedData:String,
    val type:String
)
val moviesList = listOf(
        Movies(
                "Taxi",
                R.drawable.movie1,
                "Feb, 8 2023",
                "Premieres"
        ),
        Movies(
                "Restaurant",
                R.drawable.movie2,
                "Feb, 8 2023",
                "Top Rated"
        ),
        Movies(
                "Clinic",
                R.drawable.movie3,
                "Feb, 8 2023",
                "Premieres"
        ),
        Movies(
                "Hotel",
                R.drawable.movie4,
                "Feb, 8 2023",
                "Premieres"
        ),
        Movies(
                "Taxi",
                R.drawable.movie1,
                "Feb, 8 2023",
                "Premieres"
        ),
        Movies(
                "Restorant",
                R.drawable.movie2,
                "Feb, 8 2023",
                "Premieres"
        ),
        Movies(
                "Clinic",
                R.drawable.movie3,
                "Feb, 8 2023",
                "Premieres"
        )
)
