@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WWWE"

include(":model")
include(":domain")
include(":data")
include(":remote")
include(":common:common-compose")
include(":app")
include(":feature:feature-onboarding")
include(":di")
