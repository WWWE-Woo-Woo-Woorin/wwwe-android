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
include(":core:wwwe-design-system")
include(":navigator")
include(":app")
include(":feature:feature-onboarding")
include(":feature:feature-google-sign-in")
include(":di")
