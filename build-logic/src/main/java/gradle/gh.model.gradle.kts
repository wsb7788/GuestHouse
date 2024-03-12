import extention.implementation
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import plugin.configureKotlin

configureKotlin()

dependencies {
    implementation(project(":domain:entity"))
}