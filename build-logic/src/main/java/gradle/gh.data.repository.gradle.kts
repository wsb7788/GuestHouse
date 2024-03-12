import extention.getVersionCatalog
import extention.implementation
import plugin.configureKotlin

configureKotlin()

dependencies {
    implementation(getVersionCatalog().findLibrary("java-inject").get())
    implementation(getVersionCatalog().findLibrary("kotlinx-coroutines-core").get())

    implementation(project(":domain:repository"))
    implementation(project(":domain:entity"))
    implementation(project(":data:datasource"))
    implementation(project(":data:model"))
}
