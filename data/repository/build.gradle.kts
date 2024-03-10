plugins {
    id ("gh.kotlin")
}

dependencies {
    implementation(libs.java.inject)
    implementation(project(":domain:repository"))
    implementation(project(":domain:entity"))
    implementation(project(":domain:repository"))
}
