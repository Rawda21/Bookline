package com.example.bookline.ui.hello.welcome.carousel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bookline.R
import com.example.bookline.design.PrimaryButton
import com.example.bookline.design.SecondaryButton
import com.example.bookline.design.SliderIndicator
import com.example.bookline.design.theme.BooklineTheme


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CarouselScreen(
    onNavigateFurther: () -> Unit,
    viewModel: CarouselScreenViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    if (state.isOnboardingDone) {
        LaunchedEffect(Unit) {
            onNavigateFurther()
        }
    }

    CarouselScreenContent(
            modifier = Modifier.navigationBarsPadding(),
            state = state,
            onNext = { viewModel.handleIntent(CarouselIntent.Next) },
            onSkip = { viewModel.handleIntent(CarouselIntent.Skip) }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun CarouselScreenContent(
    state: CarouselUiState,
    onNext: () -> Unit,
    onSkip: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
                modifier = Modifier.weight(1f),
                painter = painterResource(state.slide.imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop
        )
        Column(
                modifier = Modifier.padding(vertical = 24.dp, horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    text = stringResource(state.slide.headingResId),
                    style = BooklineTheme.typography.heading4,
                    textAlign = TextAlign.Center,
                    color =
                        BooklineTheme.colors.greyscale900
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                    text = stringResource(state.slide.bodyTextResId),
                    style = BooklineTheme.typography.bodyLargeRegular,
                    textAlign = TextAlign.Center,
                    color =
                        BooklineTheme.colors.greyscale700
            )
            Spacer(modifier = Modifier.height(30.dp))
            SliderIndicator(
                    slides = CarouselUiState.Slide.values().toList(),
                    currentSlide = state.slide
            )
            Spacer(modifier = Modifier.height(30.dp))
            PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.carousel_button_next),
                    onClick = onNext
            )
            Spacer(modifier = Modifier.height(16.dp))
            SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.carousel_button_skip),
                    onClick = onSkip
            )
        }
    }
}


private val CarouselUiState.Slide.imageResId: Int
    get() = when (this) {
        CarouselUiState.Slide.FIRST -> R.drawable.des_first
        CarouselUiState.Slide.SECOND -> R.drawable.des_second
        CarouselUiState.Slide.THIRD -> R.drawable.des_three
    }
private val CarouselUiState.Slide.headingResId: Int
    get() = when (this) {
        CarouselUiState.Slide.FIRST -> R.string.label_travel_with_no_worry
        CarouselUiState.Slide.SECOND -> R.string.label_find_hundreds_hotels
        CarouselUiState.Slide.THIRD -> R.string.label_discover_the_world
    }
private val CarouselUiState.Slide.bodyTextResId: Int
    get() = when (this) {
        CarouselUiState.Slide.FIRST -> R.string.label_travel_with_no_worry_description
        CarouselUiState.Slide.SECOND -> R.string.label_find_hundreds_hotels_description
        CarouselUiState.Slide.THIRD -> R.string.label_discover_the_world_description
    }
