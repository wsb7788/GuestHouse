package com.guesthouse.signup.ui.account

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guesthouse.designsystem.component.GHButton
import com.guesthouse.designsystem.component.GHPageIndicator
import com.guesthouse.designsystem.component.GHText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AccountScreen() {
    val pagerstate = rememberPagerState(0) {
        4
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GHButton(onClick = { /*TODO*/ }, text = "")
        Spacer(modifier = Modifier.height(10.dp))
        GHPageIndicator(numberOfPages = pagerstate.pageCount, selectedPage = pagerstate.currentPage)
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerstate) {

            GHText(text = "$it")
        }

    }
}