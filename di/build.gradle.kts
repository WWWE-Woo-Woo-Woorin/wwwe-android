import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugins.Android.ANDROID_LIBRARY)
    id(Plugins.Kotlin.KOTLIN_ANDROID)
    id(Plugins.Google.GOOGLE_SERVICES)
    id(Plugins.Kotlin.KOTLIN_KAPT)
}

android {
    namespace = AppConfigs.NameSpaces.DI
    compileSdk = AppConfigs.DefaultConfigs.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfigs.DefaultConfigs.MINIMUM_SDK_VERSION
        targetSdk = AppConfigs.DefaultConfigs.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String",
            "BASE_URL",
            gradleLocalProperties(rootDir).getProperty("BASE_URL"),
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfigs.BuildTypes.IS_MINIFY_ENABLED
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
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

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":local"))
    implementation(project(":remote"))

    implementation(Dependencies.Android.CORE_KTX)
    implementation(Dependencies.Android.APPCOMPAT)
    implementation(Dependencies.Android.MATERIAL)

    implementation(Dependencies.Network.OKHTTP)
    implementation(Dependencies.Network.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependencies.Network.RETROFIT)
    implementation(Dependencies.Network.GSON_CONVERTER)

    implementation(Dependencies.Google.PLAY_SERVICE_AUTH)

    implementation(Dependencies.DI.HILT_ANDROID)
    kapt(Dependencies.DI.HILT_ANDROID_COMPILER)

    implementation(Dependencies.Test.JUNIT_KTX)
    testImplementation(Dependencies.Test.JUNIT)
}
