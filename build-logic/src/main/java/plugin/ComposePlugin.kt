package plugin

import com.android.build.api.dsl.CommonExtension
import extention.androidExtension
import extention.debugImplementation
import extention.getVersionCatalog
import extention.implementation
import gradle.kotlin.dsl.accessors._b413992943a47a18774147573fc9efcd.androidTestImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun Project.configureCompose() {
    applyAndroidExtensions(androidExtension, getVersionCatalog())
    applyDependency(dependencies, getVersionCatalog())

}

private fun applyAndroidExtensions(
    androidExtension: CommonExtension<*, *, *, *, *>,
    libs: VersionCatalog
) = with(androidExtension) {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =
            libs.findVersion("kotlinCompilerExtensionVersion").get().toString()
    }
}

private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {

    implementation(platform(libs.findLibrary("androidx-compose-bom").get()))
    implementation(libs.findLibrary("androidx-material3").get())

    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation(libs.findLibrary("androidx-ui").get())
    // Android Studio Preview support
    implementation(libs.findLibrary("androidx-ui-tooling-preview").get())
    debugImplementation(libs.findLibrary("androidx-ui-tooling").get())
    // UI Tests
    androidTestImplementation(libs.findLibrary("androidx-ui-test-junit4").get())
    debugImplementation(libs.findLibrary("androidx-ui-test-manifest").get())
    debugImplementation(libs.findLibrary("androidx-ui-test-manifest").get())

    //compose-lifecycle(collectAsStateWithLifecycle)
    implementation(libs.findLibrary("lifecycle-runtime-compose").get())

}

internal class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureCompose()
        }
    }
}