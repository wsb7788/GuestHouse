import plugin.configureAndroid
import plugin.configureCompose
import plugin.configureHilt

plugins {
    id("com.android.application")
}

configureAndroid()
configureHilt()
configureCompose()
