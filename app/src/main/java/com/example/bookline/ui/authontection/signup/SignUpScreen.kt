package com.example.bookline.ui.authontection.signup

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.bookline.R
import com.example.bookline.design.Checkbox
import com.example.bookline.design.EmailInputField
import com.example.bookline.design.Navbar
import com.example.bookline.design.PasswordInputField
import com.example.bookline.design.PrimaryButton
import com.example.bookline.design.TextButton
import com.example.bookline.design.theme.BooklineTheme

@Composable
fun SignUpScreen(
    onNavigateClick: () -> Unit,
    onSignIn: () -> Unit,
    onFillProfile: () -> Unit,
//    viewModel: SignUpScreenViewModel = hiltViewModel()
) {
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun SignUpScreenContent(
    state: SignUpUiState,
    onNavigateClick: () -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onRememberMeChanged: (Boolean) -> Unit,
    onSignUp: () -> Unit,
    onSignIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
            modifier = modifier.padding(bottom = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
    ) {
        Navbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = "",
                onNavigateClick = onNavigateClick,
                actions = {}
        )
        Text(text = stringResource(R.string.sign_up_screen_heading))

        Spacer(modifier = Modifier.height(40.dp))
        Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailInputField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    onValueChange = onEmailChanged,
                    isError = !state.isValidEmail,
                    supportingText = if (!state.isValidEmail) "Invalid email" else null,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(24.dp))
            PasswordInputField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
                    onValueChange = onPasswordChanged,
                    isError = !state.isValidPassword,
                    supportingText = if (!state.isValidPassword) "Invalid password" else null
            )
            Spacer(modifier = Modifier.height(24.dp))
            Checkbox(
                    text = stringResource(R.string.remember_me),
                    checked = state.rememberMe,
                    onCheckedChange = onRememberMeChanged
            )
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.sign_up),
                    onClick = onSignUp,
                    enabled = state.isSignUpButtonEnabled
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.Center
        ) {
            Text(
                    text = stringResource(R.string.already_have_an_account),
                    style = BooklineTheme.typography.bodyMediumRegular,
                    color = BooklineTheme.colors.greyscale500
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(
                    text = stringResource(R.string.sign_in), onClick = onSignIn
            )
        }
    }
}
