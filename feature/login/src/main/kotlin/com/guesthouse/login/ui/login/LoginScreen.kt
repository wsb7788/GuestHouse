package com.guesthouse.login.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.guesthouse.designsystem.icon.GuestHouseIcons
import com.guesthouse.login.R

@Composable
fun LoginScreen(
    onEmailLoginClick: () -> Unit,
    state: LoginContract.State,
    event: (LoginContract.Event) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginLogo()
        Spacer(modifier = Modifier.height(83.dp))
        LoginIcon (
            onEmailLoginClicked = onEmailLoginClick,
            onKakaoLoginClicked = {
                event(LoginContract.Event.OnKakaoLoginButtonClicked)
            }
        )
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessSignUp()
        Spacer(modifier = Modifier.height(65.dp))
    }
}

@Composable
fun LoginLogo() {
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
        contentDescription = stringResource(R.string.logo_image)
    )
}

@Composable
fun LoginIcon(
    onEmailLoginClicked: () -> Unit,
    onKakaoLoginClicked: () -> Unit
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}, modifier = Modifier.size(54.dp)) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginNaver),
                contentDescription = stringResource(R.string.naver_social_login_button)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(
            onClick = {
                onKakaoLoginClicked()
            },
            modifier = Modifier.size(54.dp)
        ) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
                contentDescription = stringResource(R.string.kakao_social_login_button)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(onClick = {}, modifier = Modifier.size(54.dp)) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginGoogle),
                contentDescription = stringResource(R.string.google_social_login_button)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(onClick = {
            onEmailLoginClicked()
        },
            modifier = Modifier.size(54.dp)) {
            Image(
                painter = painterResource(id = GuestHouseIcons.loginEmail),
                contentDescription = stringResource(R.string.email_login_button)
            )
        }
    }
}

@Composable
fun BusinessSignUp() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            stringResource(R.string.business_admin_sign_up),
            style = TextStyle(
                fontSize = TextUnit(14f, type = TextUnitType.Sp),
                fontWeight = FontWeight(700),
                letterSpacing = TextUnit(-0.03f, type = TextUnitType.Em)
            ),
            lineHeight = TextUnit(17f, type = TextUnitType.Sp),
            textAlign = TextAlign.Right
        )
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = GuestHouseIcons.forward),
            contentDescription = stringResource(R.string.business_sign_up_button)
        )
    }
}