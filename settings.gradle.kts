@file:Suppress("UnstableApiUsage")

include(":data:model")


include(":core:network")



include(":data:datasource")


include(":data:repository")


include(":data")


include(":domain:entity")


include(":domain:repository")


include(":domain:usecase")


include(":domain")


include(":core:navigation")



include(":core:designsystem")


include(":feature:login")


include(":core:base")


pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GuestHouse"
include(
    ":app",
    ":feature:splash",
    ":core:base",
    ":feature:login",
    ":core:designsystem"
    )