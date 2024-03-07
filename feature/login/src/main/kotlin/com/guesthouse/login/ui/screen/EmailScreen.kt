package com.guesthouse.login.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guesthouse.designsystem.icon.GuestHouseIcons
import com.guesthouse.login.R

@Composable
fun EmailScreen(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CloseScreen(onBackClick)
        EmailLogin()
        LoginIdInput()
    }
}

@Composable
fun CloseScreen(onBackClick: () -> Unit) {
    IconButton(
        onClick = {
            onBackClick()
    }) {
        Icon(
            modifier = Modifier
                .padding(top = 14.dp)
                .size(24.dp),
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.close_button))
    }
}

@Composable
fun EmailLogin() {
    Text(
        modifier = Modifier.padding(top = 40.dp, start = 24.dp),
        text = stringResource(id = R.string.email_login),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}

@Composable
fun LoginIdInput() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 29.dp),
        value = text,
        onValueChange = { text = it },
        prefix = {
            Image(
                painter = painterResource(id = GuestHouseIcons.emailDefault),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        placeholder = {
            Text(
                fontSize = 12.sp,
                color = Color(0xFFD4D4D4),
                text = "이메일",
                modifier = Modifier.padding(start = 8.dp)
            )
        },
    )
}
