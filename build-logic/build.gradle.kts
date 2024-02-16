plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.android.gradle.plugin)
    implementation(libs.hilt.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("gh.hilt") {
            id = "hilt"
            implementationClass = "plugin.HiltPlugin"
        }
    }
}