package com.example.bookline.data

import android.net.Uri
import com.example.bookline.domain.entity.User

data class UserDocument(
    val fullName: String? = null,
    val email: String? = null,
    val photoUri: String? = null
) {
    fun toDomain() = User(
            email = email,
            fullName = fullName,
            photoUri = photoUri?.let { Uri.parse(photoUri) }
    )

    companion object {
        fun fromDomain(user: User) = UserDocument(
                fullName = user.fullName,
                email = user.email,
                photoUri = user.photoUri?.toString()
        )
    }
}
