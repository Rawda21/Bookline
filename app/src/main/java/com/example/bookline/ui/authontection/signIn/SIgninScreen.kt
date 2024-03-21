package com.example.bookline.ui.authontection.signIn

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bookline.R
import com.example.bookline.design.Checkbox
import com.example.bookline.design.EmailInputField
import com.example.bookline.design.PasswordInputField
import com.example.bookline.design.PrimaryButton
import com.example.bookline.design.theme.BooklineTheme
import com.example.bookline.design.TextButton

@Composable
fun SignInScreen(
    onNavigateClick: () -> Unit,
    onSignUp: () -> Unit,
    onForgotPassword: () -> Unit,
    onNavigateToHome: () -> Unit,
//    viewModel: SignInScreenViewModel = hiltViewModel()
) {
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun SignInScreenContent(
    state: SignInUiState,
    onNavigateClick: () -> Unit,
    onSignUp: () -> Unit,
    onForgotPassword: () -> Unit,
    modifier: Modifier = Modifier,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onRememberMeChanged: (Boolean) -> Unit,
    onSignIn: () -> Unit
) {
    Column(
            modifier = modifier.padding(bottom = 24.dp)
    ) {

        Text(text = stringResource(R.string.sign_in_screen_heading))

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
                    supportingText = if (!state.isValidEmail) stringResource(R.string.sign_in_screen_invalid_email) else null
            )
            Spacer(modifier = Modifier.height(24.dp))
            PasswordInputField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
                    onValueChange = onPasswordChanged,
                    isError = false,
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
                    text = stringResource(R.string.sign_in),
                    onClick = onSignIn,
                    enabled = state.isSignInButtonEnabled
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(
                    text = stringResource(R.string.forgot_the_password),
                    onClick = onForgotPassword
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
                    text = stringResource(R.string.don_t_have_an_account),
                    style = BooklineTheme.typography.bodyMediumRegular,
                    color = BooklineTheme.colors.greyscale500
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(
                    text = stringResource(R.string.sign_up),
                    onClick = onSignUp
            )
        }
    }
}



