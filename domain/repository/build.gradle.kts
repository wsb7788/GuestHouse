plugins {
    id ("gh.kotlin")
}

dependencies {
    implementation(project(":domain:entity"))
    implementation(libs.kotlinx.coroutines.core)
}