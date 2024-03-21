package com.example.bookline.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bookline.R

@Composable
fun LogoIcon(
    modifier: Modifier = Modifier,
    size: Dp = 50.dp
) {
    Box(
            modifier = modifier
                .size(size)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
    ) {
        Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
        )
    }
}
