package com.guesthouse.login.ui.email

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.guesthouse.base.use
import kotlinx.coroutines.flow.collectLatest

@Preview
@Composable
fun EmailRoute(
    onBackClick: () -> Unit = {},
    viewModel: EmailViewModel = hiltViewModel()
) {
    val (state, event, effect) = use(viewModel)

    LaunchedEffect(key1 = effect){
        effect.collectLatest {
            when(it){
                else -> {}
            }
        }
    }
    EmailScreen(onBackClick = onBackClick, event = event, state = state)
}