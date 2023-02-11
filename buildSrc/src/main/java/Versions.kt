import org.gradle.api.JavaVersion

object Versions {
    object Android {
        const val LIFECYCLE_VIEWMODEL_VERSION = "2.5.1"
        const val ACTIVITY_KTX_VERSION = "1.6.1"
        const val CORE_KTX_VERSION = "1.9.0"
        const val APPCOMPAT_VERSION = "1.6.0"
        const val MATERIAL_VERSION = "1.7.0"
    }

    object Test {
        const val JUNIT_VERSION = "4.13.2"
        const val JUNIT_KTX_VERSION = "1.1.5"
        const val COMPOSE_UI_JUNIT_VERSION = "1.3.3"
    }

    object Java {
        val JAVA_VERSION = JavaVersion.VERSION_1_8
        const val JAVA_INJECT_VERSION = "1"
    }

    object Firebase {
        const val FIREBASE_VERSION = "20.1.0"
        const val FIREBASE_AUTH_VERSION = "21.1.0"
    }

    object Gradle {
        const val GRADLE_ANDROID_VERSION = "7.3.0"
        const val GRADLE_KOTLIN_VERSION = "1.8.0"
        const val GRADLE_HILT_ANDROID_VERSION = Hilt.HILT_ANDROID_VERSION
    }

    object Google {
        const val GOOGLE_SERVICES_VERSION = "4.3.15"
        const val PLAY_SERVICES_VERSION = "20.4.0"
    }

    object Hilt {
        const val HILT_ANDROID_VERSION = "2.44"
    }

    object Network {
        const val RETROFIT_VERSION = "2.9.0"
        const val OKHTTP_VERSION = "4.10.0"
    }

    object Compose {
        const val COMPOSE_LIFECYCLE_RUNTIME_VERSION = "2.6.0-beta01"
        const val COMPOSE_HILT_NAVIGATION_VERSION = "1.0.0"
        const val ACTIVITY_COMPOSE_VERSION = "1.6.1"
        const val COMPOSE_MATERIAL_VERSION = "1.0.1"
        const val COMPOSE_CONSTRAINT_LAYOUT_VERSION = "1.0.1"
        const val COMPOSE_ANIMATION_VERSION = "1.3.3"
        const val COMPOSE_UI_VERSION = "1.3.3"
        const val COMPOSE_VIEWMODEL_VERSION = "2.5.1"
        const val COMPOSE_NAVIGATION_VERSION = "2.5.3"
    }

    object UI {
        object Pager {
            const val PAGER_VERSION = "0.28.0"
        }
    }
}
