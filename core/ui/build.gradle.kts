plugins {
    id ("gh.base")
}

android {
    namespace = "com.guesthouse.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
}