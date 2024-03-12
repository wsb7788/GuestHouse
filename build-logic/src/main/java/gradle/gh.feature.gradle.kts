import plugin.configureAndroid
import plugin.configureAndroidTest
import plugin.configureCompose
import plugin.configureFeature
import plugin.configureHilt
import plugin.configureKotlinTest
import plugin.configureNavigation

plugins {
    id("com.android.library")
}

configureAndroid()
configureHilt()
configureCompose()
configureNavigation()
configureAndroidTest()
configureKotlinTest()
configureFeature()