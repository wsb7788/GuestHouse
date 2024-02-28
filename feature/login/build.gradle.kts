@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gh.feature.login")
}

android {
    namespace = "com.guesthouse.login"
}

dependencies {
    implementation(project(":core:designsystem"))
}