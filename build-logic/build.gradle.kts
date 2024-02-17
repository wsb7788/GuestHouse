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
            id = "gh.hilt"
            implementationClass = "plugin.HiltPlugin"
        }
        register("gh.application") {
            id = "gh.application"
            implementationClass = "plugin.ApplicationPlugin"
        }
    }
}