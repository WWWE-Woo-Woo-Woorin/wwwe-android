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
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "wwwe-android"

include(":model")
include(":domain")
include(":data")
include(":remote")
include(":local")
include(":common:common-compose")
include(":core:core-route")
include(":core:wwwe-design-system")
include(":core:core-datastore")
include(":navigator")
include(":app")
include(":feature:feature-main-nav")
include(":feature:feature-onboarding")
include(":feature:feature-google-sign-in")
include(":feature:feature-chat")
include(":feature:feature-sign-up")
include(":di")
