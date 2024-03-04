package com.guesthouse.login.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.guesthouse.login.R

@Composable
fun EmailScreen(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CloseScreen(onBackClick)
    }
}

@Composable
fun CloseScreen(onBackClick: () -> Unit) {
    IconButton(
        onClick = {
            onBackClick()
    }) {
        Icon(
            modifier = Modifier.padding(top = 14.dp).size(24.dp),
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.close_button))
    }
}
