plugins {
    id(Plugins.Android.ANDROID_LIBRARY)
    id(Plugins.Kotlin.KOTLIN_ANDROID)
    id(Plugins.Kotlin.KOTLIN_KAPT)
}

android {

    namespace = AppConfigs.NameSpaces.Feature.SIGN_IN_GOOGLE

    compileSdk = AppConfigs.DefaultConfigs.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfigs.DefaultConfigs.MINIMUM_SDK_VERSION
        targetSdk = AppConfigs.DefaultConfigs.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = AppConfigs.BuildFeatures.IS_COMPOSE_ENABLED
        dataBinding = AppConfigs.BuildFeatures.IS_DATA_BINDING_ENABLED
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfigs.BuildTypes.IS_MINIFY_ENABLED
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfigs.CompileOptions.SOURCE_COMPATIBILITY
        targetCompatibility = AppConfigs.CompileOptions.TARGET_COMPATIBILITY
    }
    kotlinOptions {
        jvmTarget = AppConfigs.KotlinOptions.JVM_TARGET
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigs.ComposeOptions.KOTLIN_COMPILER_EXTENSION_VERSION
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common:common-compose"))
    implementation(project(":core:wwwe-design-system"))

    implementation(Dependencies.Android.CORE_KTX)
    implementation(Dependencies.Android.ACTIVITY_KTX)
    implementation(Dependencies.Android.APPCOMPAT)
    implementation(Dependencies.Android.MATERIAL)
    runtimeOnly(Dependencies.Android.LIFECYCLE_VIEWMODEL)

    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)

    implementation(Dependencies.Firebase.FIREBASE_AUTH)

    implementation(Dependencies.Compose.ACTIVITY_COMPOSE)
    implementation(Dependencies.Compose.COMPOSE_NAVIGATION)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL)
    implementation(Dependencies.Compose.COMPOSE_CONSTRAINT_LAYOUT)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL_WINDOW_SIZE_CLASS)
    implementation(Dependencies.Compose.COMPOSE_ANIMATION)
    implementation(Dependencies.Compose.COMPOSE_HILT_NAVIGATION)
    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_UI_TOOLING)
    implementation(Dependencies.Compose.COMPOSE_UI_TOOLING_PREVIEW)
    androidTestImplementation(Dependencies.Test.COMPOSE_UI_JUNIT)

    implementation(Dependencies.Google.PLAY_SERVICE_AUTH)

    implementation(Dependencies.UI.Pager.PAGER)
    implementation(Dependencies.UI.Pager.PAGER_INDICATOR)

    implementation(Dependencies.Test.JUNIT_KTX)
    testImplementation(Dependencies.Test.JUNIT)
    implementation(Dependencies.Compose.COMPOSE_VIEWMODEL)
}
