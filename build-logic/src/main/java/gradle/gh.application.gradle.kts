import extention.getApiKey
import plugin.configureAndroid
import plugin.configureCompose
import plugin.configureHilt
import plugin.configureSocialLogin

plugins {
    id("com.android.application")
}

android {
    defaultConfig {
        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", getApiKey("kakao_native_app_key"))
    }
}

configureAndroid()
configureHilt()
configureSocialLogin()
configureCompose()