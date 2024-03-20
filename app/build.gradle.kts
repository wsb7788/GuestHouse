@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gh.application")
}

android {
    namespace = "com.guesthouse.aos"

    defaultConfig {
        applicationId = "com.guesthouse.aos"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {

        release {
            isShrinkResources = true
            isMinifyEnabled = true
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isShrinkResources = false
            isMinifyEnabled = false
            isDebuggable = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature:splash"))
    implementation(project(":feature:login"))
    implementation(project(":feature:signup"))

    implementation(project(":domain:repository"))

    implementation(project(":data:repository"))
    implementation(project(":data:datasource"))

    implementation(project(":core:navigation"))
    implementation(project(":core:network"))
}