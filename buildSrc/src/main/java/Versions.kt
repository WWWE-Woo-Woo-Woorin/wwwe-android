import org.gradle.api.JavaVersion

object Versions {
    object Android {
        const val CORE_KTX_VERSION = "1.9.0"
        const val APPCOMPAT_VERSION = "1.6.0"
        const val MATERIAL_VERSION = "1.7.0"
    }

    object Test {
        const val JUNIT_VERSION = "4.13.2"
    }

    object Java {
        val JAVA_VERSION = JavaVersion.VERSION_1_8
        const val JAVA_INJECT_VERSION = "1"
    }

    object Firebase {
        const val FIREBASE_VERSION = "20.1.0"
    }

    object Gradle {
        const val GRADLE_ANDROID_VERSION = "7.3.0"
        const val GRADLE_KOTLIN_VERSION = "1.6.10"
        const val GRADLE_HILT_ANDROID_VERSION = Hilt.HILT_ANDROID_VERSION
    }

    object Google {
        const val GOOGLE_SERVICES_VERSION = "4.3.15"
    }

    object Hilt {
        const val HILT_ANDROID_VERSION = "2.44"
    }
}
