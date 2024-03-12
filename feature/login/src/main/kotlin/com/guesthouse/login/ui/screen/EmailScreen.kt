package com.guesthouse.login.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
        LoginPwInput()
        LoginButton()
        LoginSubFunction()
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

@Composable
fun LoginPwInput() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 16.dp),
        value = text,
        onValueChange = { text = it },
        prefix = {
            Image(
                painter = painterResource(id = GuestHouseIcons.passwordDefault),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        placeholder = {
            Text(
                fontSize = 12.sp,
                color = Color(0xFFD4D4D4),
                text = "비밀번호",
                modifier = Modifier.padding(start = 8.dp)
            )
        },
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 30.dp),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4D4D4))
        ) {
        Text(
            text = "로그인",
            modifier = Modifier.padding(vertical = 14.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LoginSubFunction() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        EmailRememberCheckBox()
        Spacer(modifier = Modifier.weight(1f))
        PassWordSearch()
    }
}

@Composable
private fun EmailRememberCheckBox() {
    var isChecked by remember { mutableStateOf(false) }

    Checkbox(
        checked = isChecked,
        onCheckedChange = {
            isChecked = !isChecked
        },
        modifier = Modifier
            .padding(end = 8.dp)
            .size(16.dp),
    )
    Text(
        text = "이메일 기억하기",
        fontSize = 12.sp,
    )
}

@Composable
fun PassWordSearch() {
    Text(
        text = "비밀번호 찾기",
        fontSize = 12.sp,
    )
}
