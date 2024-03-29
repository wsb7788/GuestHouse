package com.guesthouse.login.ui.email

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guesthouse.designsystem.component.GHBottomSheet
import com.guesthouse.designsystem.component.GHButton
import com.guesthouse.designsystem.component.GHImageButton
import com.guesthouse.designsystem.component.GHOutLinedTextField
import com.guesthouse.designsystem.component.GHText
import com.guesthouse.designsystem.icon.GuestHouseIcons
import com.guesthouse.designsystem.theme.Neutral100
import com.guesthouse.designsystem.theme.NeutralWhite
import com.guesthouse.login.R
import com.guesthouse.login.ui.login.LoginIcon

@Composable
fun EmailScreen(
    onBackClick: () -> Unit = {},
    event: (EmailContract.Event) -> Unit,
    state: EmailContract.State,
) {
    var bottomSheetVisible by remember { mutableStateOf(false) }

    if (bottomSheetVisible) {
        GHBottomSheet(
            onDismissRequest = {
                bottomSheetVisible = false
            }
        ) {
            Spacer(modifier = Modifier.height(330.dp))
            GHButton(
                onClick = {
                    bottomSheetVisible = false
                    event(EmailContract.Event.OnSignUpContinueButtonClicked)
                },
                text = stringResource(R.string.agree_and_continue_sign_up_button)
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    Scaffold(
        topBar = {
            CloseScreenButton(onBackClick)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            EmailLoginText()
            Spacer(modifier = Modifier.height(29.dp))
            LoginIdInput(
                email = state.email,
                onEmailChanged = { email ->
                    event(EmailContract.Event.OnEmailChanged(email))
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            LoginPwInput(
                password = state.password,
                onPasswordChanged = { password ->
                    event(EmailContract.Event.OnPasswordChanged(password))
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            LoginButton(
                enabled = state.email.isNotEmpty() && state.password.isNotEmpty(),
                onLoginButtonClicked = {
                    event(EmailContract.Event.OnLoginButtonClicked)
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            LoginSubSection {
                event(EmailContract.Event.OnFindPasswordButtonClicked)
            }
            Spacer(modifier = Modifier.weight(1f))
            LoginIcon(onEmailLoginClicked = { /*TODO*/ }) {

            }
            Spacer(modifier = Modifier.height(28.dp))
            SignUpSection(
                onSignUpWithEmailButtonClicked = {
                    bottomSheetVisible = true
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
        }

    }

}

@Composable
fun SignUpSection(onSignUpWithEmailButtonClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GHText(
            text = stringResource(R.string.sign_up_guest_house_message),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.width(11.dp))
        GHText(
            modifier = Modifier.clickable { onSignUpWithEmailButtonClicked() },
            text = stringResource(R.string.sign_up_with_email),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun CloseScreenButton(onBackClick: () -> Unit) {
    IconButton(
        onClick = {
            onBackClick()
        }) {
        Icon(
            modifier = Modifier
                .padding(top = 14.dp)
                .size(24.dp),
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.close_button)
        )
    }
}

@Composable
fun EmailLoginText() {
    GHText(
        text = stringResource(id = R.string.email_login),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}

@Composable
fun LoginIdInput(email: String, onEmailChanged: (String) -> Unit) {
    GHOutLinedTextField(
        value = email,
        onValueChange = { onEmailChanged(it) },
        hint = stringResource(id = R.string.email_hint),
        leadingIcon = {
            Image(
                painter = painterResource(
                    id =
                    if (email.isNotEmpty()) {
                        com.guesthouse.designsystem.R.drawable.icon_email_entered
                    } else {
                        com.guesthouse.designsystem.R.drawable.icon_email_default
                    }
                ),
                contentDescription = stringResource(R.string.email_text_input_area)
            )
        },
        trailingIcon = {
            if (email.isNotEmpty()) {
                GHImageButton(
                    containerModifier = Modifier
                        .clip(CircleShape)
                        .size(18.dp)
                        .background(Neutral100),
                    imageModifier = Modifier.size(6.75.dp),
                    imageColorFilter = ColorFilter.tint(NeutralWhite),
                    onClick = { onEmailChanged("") },
                    imageResId = com.guesthouse.designsystem.R.drawable.icon_cancel,
                    imageDescriptionResId = R.string.email_text_input_area_clear_button
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        singleLine = true
    )
}

@Composable
fun LoginPwInput(password: String, onPasswordChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    GHOutLinedTextField(
        value = password,
        onValueChange = { onPasswordChanged(it) },
        hint = stringResource(id = R.string.password_hint),
        leadingIcon = {
            Image(
                painter = painterResource(
                    id =
                    if (password.isNotEmpty()) {
                        GuestHouseIcons.passwordEntered
                    } else {
                        GuestHouseIcons.passwordDefault
                    }
                ),
                contentDescription = stringResource(R.string.password_text_input_area)
            )
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            if (password.isNotEmpty()) {
                GHImageButton(
                    imageModifier = Modifier.size(18.dp),
                    imageColorFilter = ColorFilter.tint(Neutral100),
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    },
                    imageResId =
                    if (passwordVisibility)
                        GuestHouseIcons.visible
                    else
                        GuestHouseIcons.invisible,
                    imageDescriptionResId = R.string.password_visibility_toggle_button
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true
    )
}

@Composable
fun LoginButton(enabled: Boolean, onLoginButtonClicked: () -> Unit) {
    GHButton(
        enabled = enabled,
        onClick = { onLoginButtonClicked() },
        text = stringResource(R.string.email_login_button_text)
    )
}

@Composable
fun LoginSubSection(onFindPasswordButtonClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        EmailRememberCheckBox()
        PassWordSearch(onFindPasswordButtonClicked = onFindPasswordButtonClicked)
    }
}

@Composable
private fun EmailRememberCheckBox() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = !isChecked
            },
            modifier = Modifier
                .size(16.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))
        GHText(
            text = stringResource(R.string.remember_email),
            fontSize = 12.sp,
        )
    }

}

@Composable
fun PassWordSearch(onFindPasswordButtonClicked: () -> Unit) {
    GHText(
        modifier = Modifier.clickable { onFindPasswordButtonClicked() },
        text = stringResource(R.string.find_my_password),
        fontSize = 12.sp,
    )
}
