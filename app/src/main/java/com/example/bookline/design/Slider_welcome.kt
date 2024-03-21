package com.example.bookline.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.bookline.design.theme.BooklineTheme

@Composable
fun <T> SliderIndicator(
    slides: List<T>,
    currentSlide: T,
    modifier: Modifier = Modifier
) {
    Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
    ) {
        slides.forEach { slide ->
            val active = slide == currentSlide
            IndicatorDot(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    active = active
            )
        }
    }
}
@Composable
private fun IndicatorDot(
    active: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
            modifier = modifier
                .size(8.dp)
                .clip(CircleShape)
                .then(
                        if (active) {
                            Modifier.background(Brush.linearGradient(BooklineTheme.colors.gradientGreen))
                        } else {
                            Modifier.background(BooklineTheme.colors.greyscale300)
                        }
                )
    )
}