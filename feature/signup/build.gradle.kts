@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gh.feature.signup")
}

android {
    namespace = "com.guesthouse.signup"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:base"))
}