object Plugins {
    object Android {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
    }

    object Kotlin {
        const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    }

    object Java {
        const val JAVA_LIBRARY = "java-library"
    }

    object DI {
        const val HILT_ANDROID = "dagger.hilt.android.plugin"
    }

    object Google {
        const val GOOGLE_SERVICES = "com.google.gms.google-services"
    }

    object Gradle {
        const val GRADLE_ANDROID =
            "com.android.tools.build:gradle:${Versions.Gradle.GRADLE_ANDROID_VERSION}"
        const val GRADLE_KOTLIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Gradle.GRADLE_KOTLIN_VERSION}"
        const val GRADLE_HILT_ANDROID =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.Gradle.GRADLE_HILT_ANDROID_VERSION}"
        const val GOOGLE_SERVICES =
            "com.google.gms:google-services:${Versions.Google.GOOGLE_SERVICES_VERSION}"
    }
}
