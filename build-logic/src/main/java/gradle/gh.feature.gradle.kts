import plugin.configureAndroid
import plugin.configureAndroidTest
import plugin.configureCompose
import plugin.configureFeature
import plugin.configureHilt
import plugin.configureKotlinTest

plugins {
    id("com.android.library")
}

configureAndroid()
configureHilt()
configureCompose()
configureAndroidTest()
configureKotlinTest()
configureFeature()