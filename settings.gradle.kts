@file:Suppress("UnstableApiUsage")


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
        maven {
            setUrl("https://devrepo.kakao.com/nexus/content/groups/public/")
        }
    }
}

rootProject.name = "GuestHouse"
include(
    ":app",
    ":feature:splash",
    ":feature:signup",
    ":feature:login",
    ":core:base",
    ":core:navigation",
    ":core:designsystem",
    ":core:network",
    ":domain:entity",
    ":domain:repository",
    ":domain:usecase",
    ":data:repository",
    ":data:datasource",
    ":data:model",
)