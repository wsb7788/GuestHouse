plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.android.gradle.plugin)
    implementation(libs.hilt.android.gradle.plugin)
}

gradlePlugin {
    /*plugins {
        register("hilt") {
            id = "hiltz"
            implementationClass = "plugin.HiltPlugin"
        }
        register("application") {
            id = "applicationz"
            implementationClass = "plugin.ApplicationPlugin"
        }
    }*/
}