object Dependencies {
    object Android {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.Android.CORE_KTX_VERSION}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.Android.APPCOMPAT_VERSION}"
        const val MATERIAL =
            "com.google.android.material:material:${Versions.Android.MATERIAL_VERSION}"
    }

    object Java {
        const val INJECT = "javax.inject:javax.inject:${Versions.Java.JAVA_INJECT_VERSION}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT_VERSION}"
        const val JUNIT_KTX = "androidx.test.ext:junit-ktx:${Versions.Test.JUNIT_KTX_VERSION}"
        const val COMPOSE_UI_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.Test.COMPOSE_UI_JUNIT_VERSION}"
    }

    object Firebase {
        const val FIREBASE_STORAGE =
            "com.google.firebase:firebase-storage-ktx:${Versions.Firebase.FIREBASE_VERSION}"
        const val FIREBASE_AUTH =
            "com.google.firebase:firebase-auth-ktx:${Versions.Firebase.FIREBASE_AUTH_VERSION}"
    }

    object Hilt {
        const val HILT_ANDROID =
            "com.google.dagger:hilt-android:${Versions.Hilt.HILT_ANDROID_VERSION}"
        const val HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT_ANDROID_VERSION}"
    }

    object Network {
        const val OKHTTP =
            "com.squareup.okhttp3:okhttp:${Versions.Network.OKHTTP_VERSION}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OKHTTP_VERSION}"
        const val RETROFIT =
            "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT_VERSION}"
        const val GSON_CONVERTER =
            "com.squareup.retrofit2:converter-gson:${Versions.Network.RETROFIT_VERSION}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE =
            "androidx.activity:activity-compose:${Versions.Compose.ACTIVITY_COMPOSE_VERSION}"
        const val COMPOSE_MATERIAL =
            "androidx.compose.material:material:${Versions.Compose.COMPOSE_MATERIAL_VERSION}"
        const val COMPOSE_ANIMATION =
            "androidx.compose.animation:animation:${Versions.Compose.COMPOSE_ANIMATION_VERSION}"
        const val COMPOSE_UI =
            "androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE_UI_VERSION}"
        const val COMPOSE_VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.COMPOSE_VIEWMODEL_VERSION}"
    }
}
