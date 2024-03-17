package com.guesthouse.aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.guesthouse.aos.navigation.GhMainRoute
import com.guesthouse.splash.ui.theme.GuestHouseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuestHouseTheme {
                GhMainRoute()
            }
        }
    }
}