package com.guesthouse.aos

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKakaoSDK()
    }

    private fun initKakaoSDK() {
        KakaoSdk.init(this, "3d054d6b414feac6f78dfed8461cbefc")
    }
}