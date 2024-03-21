package com.example.bookline.design

import android.os.Build
import android.provider.CalendarContract
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bookline.design.theme.BooklineColorSchema
import com.example.bookline.design.theme.BooklineTheme
import com.example.bookline.ui.theme.BooklineTheme

private object PrimaryButtonDefaults {
    @Composable
    fun containerColor() = BooklineTheme.colors.primary500

    @Composable
    fun contentColor() = BooklineTheme.colors.white
    @Composable
    fun disabledContainerColor() = BooklineTheme.colors.buttonDisabled
}
private object SecondaryButtonDefaults {
    val IconSize = 20.dp

    @Composable
    fun containerColor() = BooklineTheme.colors.primary100

    @Composable
    fun contentColor() = BooklineTheme.colors.primary500
}

@RequiresApi(Build.VERSION_CODES.O)
private fun Modifier.drawColoredShadow(
    color: Color = Color(0xFF1AB65C),
    alpha: Float = 0.25f,
    shadowRadius: Dp = 24.dp,
    offsetX: Dp = 4.dp,
    offsetY: Dp = 8.dp,
    borderRadius: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
        )
        it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
        )
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = BooklineTheme.shapes.circular,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 18.dp)
) {
    val colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryButtonDefaults.containerColor(),
            contentColor = PrimaryButtonDefaults.contentColor(),
            disabledContainerColor = PrimaryButtonDefaults.disabledContainerColor(),
            disabledContentColor = PrimaryButtonDefaults.contentColor(),
    )

    val elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp
    )

    ElevatedButton(
            modifier = modifier
                .then(if (enabled) Modifier.drawColoredShadow() else Modifier),
            shape = shape,
            colors = colors,
            enabled = enabled,
            onClick = onClick,
            elevation = elevation,
            contentPadding = contentPadding
    ) {
        Text(
                text = text,
                style = BooklineTheme.typography.bodyLargeBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes leadingIconResId: Int? = null,
    @DrawableRes trailingIconResId: Int? = null,
    shape: Shape = BooklineTheme.shapes.circular,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 18.dp)
) {
    val colors = ButtonDefaults.buttonColors(
            containerColor = SecondaryButtonDefaults.containerColor(),
            contentColor = SecondaryButtonDefaults.contentColor()
    )

    Button(
            modifier = modifier,
            shape = shape,
            colors = colors,
            onClick = onClick,
            contentPadding = contentPadding
    ) {
        leadingIconResId?.let { id ->
            Icon(
                    modifier = Modifier.size(SecondaryButtonDefaults.IconSize),
                    painter = painterResource(id),
                    contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Text(
                text = text,
                style = BooklineTheme.typography.bodyLargeBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
        )
        trailingIconResId?.let { id ->
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                    modifier = Modifier.size(SecondaryButtonDefaults.IconSize),
                    painter = painterResource(id),
                    contentDescription = null
            )
        }
    }
}

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = BooklineTheme.colors.primary500
) {
    Text(
            modifier = modifier
                .clip(BooklineTheme.shapes.extraSmall)
                .clickable(
                        onClick = onClick,
                        role = Role.Button
                )
                .padding(2.dp),
            text = text,
            style = BooklineTheme.typography.bodyMediumSemiBold,
            color = color
    )
}
