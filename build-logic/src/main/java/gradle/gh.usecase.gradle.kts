import extention.getVersionCatalog
import extention.implementation
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import plugin.configureKotlin

configureKotlin()

dependencies {
    implementation(getVersionCatalog().findLibrary("java-inject").get())
    implementation(getVersionCatalog().findLibrary("kotlinx-coroutines-core").get())

    implementation(project(":domain:repository"))
    implementation(project(":domain:entity"))
}