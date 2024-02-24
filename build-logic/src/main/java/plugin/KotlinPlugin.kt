package plugin

import extention.getPluginId
import extention.getVersionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class KotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureKotlin()
        }
    }
}

internal fun Project.configureKotlin() {
    applyPlugin(pluginManager, getVersionCatalog())
    applyJavaPluginExtension(extensions.getByType())
}


private fun applyPlugin(manager: PluginManager, libs: VersionCatalog) = with(manager) {
    apply(libs.getPluginId("kotlin-jvm"))
}

private fun applyJavaPluginExtension(extension: JavaPluginExtension) = with(extension) {
    sourceCompatibility = Build.SOURCE_COMPATIBILITY
    targetCompatibility = Build.TARGET_COMPATIBILITY
}