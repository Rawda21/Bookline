package com.example.bookline.ui.hello.welcome.carousel

sealed interface CarouselIntent {
    object Next : CarouselIntent
    object Skip : CarouselIntent
}