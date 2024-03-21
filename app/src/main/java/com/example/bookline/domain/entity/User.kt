package com.example.bookline.domain.entity

import android.net.Uri
import java.time.LocalDate

data class User(
    val email: String?,
    val fullName: String?,
    val photoUri: Uri?
)
