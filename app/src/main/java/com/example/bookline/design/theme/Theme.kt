package com.example.bookline.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
data class DarkTheme(val isDark: Boolean = false)

val LocalTheme = compositionLocalOf { DarkTheme() }

@Composable
fun HeliaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = DarkTheme(darkTheme)
    CompositionLocalProvider(
            LocalBooklineTypography provides booklineTypography,
            LocalBooLineShapes provides booklineShapes,
            LocalBooklineColorSchema provides booklineColorSchema,
            LocalTheme provides theme
    ) {
        MaterialTheme(content = content)
    }
}

object BooklineTheme {
    val typography: BooklineTypography
        @Composable
        get() = LocalBooklineTypography.current
    val shapes: BooklineShapes
        @Composable
        get() = LocalBooLineShapes.current
    val colors: BooklineColorSchema
        @Composable
        get() = LocalBooklineColorSchema.current
    val theme: DarkTheme
        @Composable
        get() = LocalTheme.current

    val primaryTextColor
        @Composable get() = if (theme.isDark) colors.white else colors.greyscale900

    val secondaryTextColor
        @Composable get() = if (theme.isDark) colors.greyscale100 else colors.greyscale800

    val backgroundColor
        @Composable get() = if (theme.isDark) colors.dark1 else colors.white
}


object LoginSocialButtonRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = BooklineTheme.colors.primary200

    @Composable
    override fun rippleAlpha(): RippleAlpha {
        return RippleTheme.defaultRippleAlpha(Color.Black, lightTheme = !isSystemInDarkTheme())
    }
}