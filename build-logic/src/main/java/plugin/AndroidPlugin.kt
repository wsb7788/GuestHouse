package plugin

import Build
import com.android.build.api.dsl.CommonExtension
import extention.getPluginId
import extention.getVersionCatalog
import extention.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class AndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureAndroid()
        }
    }
}

internal fun Project.configureAndroid() {
    applyPlugin(pluginManager, getVersionCatalog())
    applyAndroidExtensions(extensions.getByType(CommonExtension::class))
}

private fun applyPlugin(manager: PluginManager, libs: VersionCatalog) = with(manager) {
    apply(libs.getPluginId("android-application"))
    apply(libs.getPluginId("kotlin-android"))
}

private fun applyAndroidExtensions(extensions: CommonExtension<*, *, *, *, *>) = with(extensions) {

    compileSdk = Build.COMPILE_SDK

    defaultConfig {

        minSdk = Build.MIN_SDK

        compileOptions {
            sourceCompatibility = Build.SOURCE_COMPATIBILITY
            targetCompatibility = Build.TARGET_COMPATIBILITY
        }

        kotlinOptions {
            jvmTarget = Build.JVM_TARGET
        }
    }
}