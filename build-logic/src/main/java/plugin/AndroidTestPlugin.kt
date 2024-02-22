package plugin

import com.android.build.api.dsl.CommonExtension
import extention.debugImplementation
import extention.getVersionCatalog
import gradle.kotlin.dsl.accessors._b413992943a47a18774147573fc9efcd.androidTestImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.getByType

internal class AndroidTestPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureAndroidTest()
        }
    }
}

internal fun Project.configureAndroidTest() {
    applyAndroidExtensions(extensions.getByType(CommonExtension::class))
    applyDependency(dependencies, getVersionCatalog())
}

private fun applyAndroidExtensions(extensions: CommonExtension<*, *, *, *, *>) = with(extensions) {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {
    androidTestImplementation(libs.findLibrary("androidx-espresso-core").get())
    androidTestImplementation(libs.findLibrary("androidx-junit").get())
    androidTestImplementation(libs.findLibrary("androidx-ui-test-junit4").get())
    debugImplementation(libs.findLibrary("androidx-ui-test-manifest").get())
}

