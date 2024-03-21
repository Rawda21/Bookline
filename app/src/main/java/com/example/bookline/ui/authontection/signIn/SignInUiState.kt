package com.example.bookline.ui.authontection.signIn

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val isSignInSuccessful: Boolean = false,
    val signInError: Boolean = false,
    val isValidEmail: Boolean = true,
    val isValidPassword: Boolean = true,
    val signedIn: Boolean = false,
    val isLoading: Boolean = false,
    val isSignInWithGoogleDialogOpen: Boolean = false,
    val signInWithGoogle: Boolean = false,
    val wrongPassword: Boolean = false,
    val userNotFound: Boolean = false,
    val emailAssociatedWithGoogle: Boolean = false,
    val wrongPasswordAndEmailAssociatedWithGoogle: Boolean = false
){
    val isSignInButtonEnabled
        get() = email.isNotEmpty() && isValidEmail && password.length > 5 && isValidPassword

    fun checkRememberMe() = copy(rememberMe = !rememberMe)

    fun signedIn() = copy(signedIn = true)

    fun inputEmail(value: String): SignInUiState {
        val isValid = value.isEmpty() || value.isNotBlank()
        return copy(email = value, isValidEmail = isValid)
    }
    fun inputPassword(value: String) = copy(password = value, isValidPassword = true)

    fun passwordIsNotValid() = copy(isValidPassword = false)

    fun emailIsNotValid() = copy(isValidEmail = false)

    fun updateIsLoading(loading: Boolean) = copy(isLoading = loading)

    fun signInError() = copy(isLoading = false, signInError = true)

    fun signInErrorShown() = copy(signInError = false)
    fun updateWrongPassword(wrong: Boolean) = copy(wrongPassword = wrong)
    fun updateUserNotFound(userNotFound: Boolean) = copy(userNotFound = userNotFound)

}
