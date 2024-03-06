package com.guesthouse.login.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.guesthouse.designsystem.icon.GuestHouseIcons
import com.guesthouse.login.R

@Composable
fun LoginScreen(
    onEmailLoginClick:() -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LoginLogo()
            LoginIcon(onEmailLoginClick)
        }
    }
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        BusinessSignUp()
    }
}

@Composable
fun LoginLogo() {
    Image(
        painter = painterResource(id = GuestHouseIcons.socialLoginNaver),
        contentDescription = stringResource(id = R.string.main_logo),
        modifier = Modifier.size(100.dp)
    )
}

@Composable
fun LoginIcon(
    onEmailLoginClick: () -> Unit
) {
    val images = listOf(GuestHouseIcons.socialLoginNaver, GuestHouseIcons.socialLoginKaKao, GuestHouseIcons.loginEmail, GuestHouseIcons.socialLoginGoogle)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 52.dp, end = 52.dp, top = 83.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        images.forEach { image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = R.string.icon),
                modifier = Modifier
                    .clickable {
                        when (image) {
                            GuestHouseIcons.socialLoginNaver -> {

                            }
                            GuestHouseIcons.socialLoginKaKao -> {

                            }
                            GuestHouseIcons.loginEmail -> {
                                onEmailLoginClick()
                            }
                        }
                    }
                    .size(54.dp))
        }
    }
}

@Composable
fun BusinessSignUp() {
    Text(
        modifier = Modifier.padding(31.dp),
        text = stringResource(id = R.string.business_or_admin_sign_up),
        fontWeight = FontWeight.Bold,
    )
}