package com.guesthouse.login.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guesthouse.designsystem.component.GHText
import com.guesthouse.designsystem.icon.GuestHouseIcons
import com.guesthouse.login.R

@Composable
fun LoginScreen(
    state: LoginContract.State,
    event: (LoginContract.Event) -> Unit
) {

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        LoginLogo(modifier = Modifier.size(100.dp))
        Spacer(modifier = Modifier.heightIn(83.dp))
        LoginIcon (
            modifier = Modifier.heightIn(54.dp),
            onEmailLoginClicked = {
                event(LoginContract.Event.OnEmailLoginButtonClicked)
            },
            onKakaoLoginClicked = {
                event(LoginContract.Event.OnKakaoLoginButtonClicked)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        BusinessSignUp()
        Spacer(modifier = Modifier.heightIn(65.dp))
    }

}

@Composable
fun LoginLogo(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
        contentDescription = stringResource(R.string.logo_image)
    )
}

@Composable
fun LoginIcon(
    modifier: Modifier = Modifier,
    onEmailLoginClicked: () -> Unit,
    onKakaoLoginClicked: () -> Unit
) {
    Row(
        modifier = modifier,
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
fun BusinessSignUp(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GHText(
            stringResource(R.string.business_admin_sign_up),
            fontSize = 14.sp,
        )
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = GuestHouseIcons.forward),
            contentDescription = stringResource(R.string.business_sign_up_button)
        )
    }
}