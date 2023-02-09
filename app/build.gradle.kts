plugins {
    id(Plugins.Android.ANDROID_APPLICATION)
    id(Plugins.Kotlin.KOTLIN_ANDROID)
    id(Plugins.DI.HILT_ANDROID)
    id(Plugins.Kotlin.KOTLIN_KAPT)
}

android {

    namespace = AppConfigs.NameSpaces.APP

    compileSdk = AppConfigs.DefaultConfigs.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AppConfigs.DefaultConfigs.APPLICATION_ID
        minSdk = AppConfigs.DefaultConfigs.MINIMUM_SDK_VERSION
        targetSdk = AppConfigs.DefaultConfigs.TARGET_SDK_VERSION
        versionCode = AppConfigs.DefaultConfigs.VERSION_CODE
        versionName = AppConfigs.DefaultConfigs.VERSION_NAME

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
    implementation(project(":remote"))
    implementation(project(":di"))
    implementation(project(":feature:feature-onboarding"))
    implementation(project(":feature:feature-google-sign-in"))

    implementation(Dependencies.Android.CORE_KTX)
    implementation(Dependencies.Android.ACTIVITY_KTX)
    implementation(Dependencies.Android.APPCOMPAT)
    implementation(Dependencies.Android.MATERIAL)
    runtimeOnly(Dependencies.Android.LIFECYCLE_VIEWMODEL)

    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)

    implementation(Dependencies.Compose.ACTIVITY_COMPOSE)
    implementation(Dependencies.Compose.COMPOSE_NAVIGATION)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL_WINDOW_SIZE_CLASS)
    implementation(Dependencies.Compose.COMPOSE_ANIMATION)
    implementation(Dependencies.Compose.COMPOSE_UI)
    androidTestImplementation(Dependencies.Test.COMPOSE_UI_JUNIT)

    implementation(Dependencies.Test.JUNIT_KTX)
    testImplementation(Dependencies.Test.JUNIT)
    implementation(Dependencies.Compose.COMPOSE_VIEWMODEL)
}

kapt {
    correctErrorTypes = true
}
