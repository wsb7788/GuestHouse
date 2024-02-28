import plugin.configureAndroid
import plugin.configureHilt
import plugin.configureSocialLogin

plugins {
    id("com.android.application")
}

configureAndroid()
configureHilt()
configureSocialLogin()