package com.example.bookline.ui.authontection.signup

data class SignUpUiState(
    val email: String = "",
    val isValidEmail: Boolean = true,
    val password: String = "",
    val isValidPassword: Boolean = true,
    val rememberMe: Boolean = false,
    val isLoading: Boolean = false,
    val userCreated: Boolean = false,
    val isEmailAlreadyInUseDialogOpen: Boolean = false,
    val isEmailAlreadyInUseWithGoogleDialogOpen: Boolean = false,
    val signInWithGoogle: Boolean = false,
    val signInError: Boolean = false,
){
    val isSignUpButtonEnabled
        get() = email.isNotEmpty() && isValidEmail && password.isNotEmpty() && isValidPassword

    fun checkRememberMe() = copy(rememberMe = !rememberMe)

    fun userCreated() = copy(userCreated = true)

    fun inputEmail(value: String): SignUpUiState {
        val isValid = value.isEmpty() || value.isNotBlank()
        return copy(email = value, isValidEmail = isValid)
    }

    fun inputPassword(value: String) = copy(password = value, isValidPassword = true)

    fun passwordIsNotValid() = copy(isValidPassword = false)

    fun emailIsNotValid() = copy(isValidEmail = false)

    fun updateIsLoading(loading: Boolean) = copy(isLoading = loading)

    fun updateEmailAlreadyInUseDialogOpen(open: Boolean) = copy(
            isEmailAlreadyInUseDialogOpen = open
    )

    fun signInError() = copy(isLoading = false, signInError = true)

    fun signInErrorShown() = copy(signInError = false)
}

