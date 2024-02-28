package plugin

import extention.getVersionCatalog
import extention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler

internal class SocialLoginPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureAndroid()
        }
    }
}

internal fun Project.configureSocialLogin() {
    applyDependency(dependencies, getVersionCatalog())
}

private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {
    implementation(libs.findLibrary("kakao-login").get())
}