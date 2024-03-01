@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gh.feature")
}

android {
    namespace = "com.guesthouse.login"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))
}