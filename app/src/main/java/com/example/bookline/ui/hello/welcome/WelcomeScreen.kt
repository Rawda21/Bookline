package com.example.bookline.ui.hello.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookline.R
import com.example.bookline.design.theme.BooklineTheme
import kotlinx.coroutines.delay


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onNavigateFurther: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.img_welcome),
                contentDescription = null,
                contentScale = ContentScale.Crop
        )
        Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(Brush.verticalGradient(BooklineTheme.colors.gradientDark))
        ) {
            Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(horizontal = 24.dp, vertical = 48.dp)

            ) {
                Text(
                        text = stringResource(R.string.welcome_screen_title),
                        style = BooklineTheme.typography.heading2,
                        color = BooklineTheme.colors.white
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                        text = stringResource(id = R.string.app_name),
                        style = BooklineTheme.typography.heading1.copy(
                                brush = Brush.linearGradient(BooklineTheme.colors.gradientGreen),
                                fontSize = 80.sp
                        )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                        text = stringResource(R.string.welcome_screen_subtitle),
                        style = BooklineTheme.typography.bodyXLargeSemiBold,
                        color = BooklineTheme.colors.white
                )
            }

        }
    }

    LaunchedEffect(Unit) {
        delay(2_000)
        onNavigateFurther()
    }
}
