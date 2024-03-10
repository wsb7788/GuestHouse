import extention.getVersionCatalog
import extention.implementation
import plugin.configureKotlin

configureKotlin()

dependencies {
    implementation(getVersionCatalog().findLibrary("kotlinx-coroutines-core").get())
    implementation(project(":domain:entity"))
}