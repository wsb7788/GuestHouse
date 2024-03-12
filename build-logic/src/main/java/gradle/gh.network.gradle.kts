import extention.getVersionCatalog
import gradle.kotlin.dsl.accessors._b413992943a47a18774147573fc9efcd.implementation
import plugin.configureAndroid
import plugin.configureHilt

plugins {
    id("com.android.library")
}

configureAndroid()
configureHilt()

dependencies {
    implementation(getVersionCatalog().findBundle("ktor").get())

    implementation(project(":data:datasource"))
    implementation(project(":data:model"))
    implementation(project(":domain:entity"))
}