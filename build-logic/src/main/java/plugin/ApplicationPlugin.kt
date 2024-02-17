package plugin

import Build
import com.android.build.api.dsl.CommonExtension
import extention.getPluginId
import extention.getVersionCatalog
import extention.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class ApplicationPlugin: Plugin<Project>{
    override fun apply(target: Project) {
        applyPlugin(target.pluginManager, target.getVersionCatalog())
        applyAndroidExtensions(target.extensions.getByType(CommonExtension::class))
        applyDependency(target.dependencies, target.getVersionCatalog())
    }

    private fun applyPlugin(manager: PluginManager, libs: VersionCatalog) = with(manager) {
        apply(libs.getPluginId("androidApplication"))
        apply(libs.getPluginId("kotlinAndroid"))
    }

    private fun applyAndroidExtensions(extensions: CommonExtension<*, *, *, *, *>) = with(extensions) {

        compileSdk = Build.COMPILE_SDK

        defaultConfig {

            minSdk = Build.MIN_SDK
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

            compileOptions {
                sourceCompatibility = Build.SOURCE_COMPATIBILITY
                targetCompatibility = Build.TARGET_COMPATIBILITY
            }

            kotlinOptions {
                jvmTarget = Build.JVM_TARGET
            }


        }
    }

    private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {

    }

}