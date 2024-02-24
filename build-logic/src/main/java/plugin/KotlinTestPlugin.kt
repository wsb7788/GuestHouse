package plugin

import extention.getVersionCatalog
import extention.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler

internal class KotlinTestPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureKotlinTest()
        }
    }
}

internal fun Project.configureKotlinTest() {
    applyDependency(dependencies, getVersionCatalog())
}

private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {
    testImplementation(libs.findLibrary("androidx-junit").get())
    testImplementation(libs.findBundle("kotest").get())
}