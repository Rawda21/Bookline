package com.example.bookline.design

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.window.DialogProperties
import com.example.bookline.design.theme.BooklineTheme
import com.example.bookline.ui.theme.BooklineTheme

@Composable
fun Dialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = BooklineTheme.shapes.medium,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit,
) {
    androidx.compose.ui.window.Dialog(
            onDismissRequest = onDismissRequest,
            properties = properties
    ) {
        BackgroundSurface(modifier = modifier.clip(shape)) {
            Box(modifier = Modifier) {
                content()
            }
        }
    }
}
@Composable
fun BackgroundSurface(
    modifier: Modifier = Modifier,
    color: Color = BooklineTheme.backgroundColor,
    content: @Composable () -> Unit
) {
    Surface(modifier = modifier, color = color, content = content)
}