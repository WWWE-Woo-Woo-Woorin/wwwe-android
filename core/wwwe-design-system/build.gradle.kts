plugins {
    id(Plugins.Android.ANDROID_LIBRARY)
    id(Plugins.Kotlin.KOTLIN_ANDROID)
}

android {
    namespace = AppConfigs.NameSpaces.Core.WWWE_DESIGN_SYSTEM
    compileSdk = AppConfigs.DefaultConfigs.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfigs.DefaultConfigs.MINIMUM_SDK_VERSION
        targetSdk = AppConfigs.DefaultConfigs.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_UI_TOOLING)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL)
    implementation(Dependencies.Compose.ACTIVITY_COMPOSE)
}
