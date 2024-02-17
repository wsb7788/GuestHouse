package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

internal class KotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            configureKotlin()
        }
    }



}

private fun Project.configureKotlin() {
    applyPlugin(pluginManager)
    applyJavaPluginExtension(extensions.getByType())
}

private fun applyPlugin(manager: PluginManager) = with(manager) {
    apply("kotlinJvm")
}

private fun applyJavaPluginExtension(extension: JavaPluginExtension) = with(extension) {
    sourceCompatibility = Build.SOURCE_COMPATIBILITY
    targetCompatibility = Build.TARGET_COMPATIBILITY
}