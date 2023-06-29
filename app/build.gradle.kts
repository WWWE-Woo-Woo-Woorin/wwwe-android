@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("android")
    id("com.android.application")
    id("kotlinx-serialization")
    id("com.google.gms.google-services")
}

android {
    namespace = "app.junsu.wwwe"
    compileSdk = 33

    defaultConfig {
        applicationId = "app.junsu.wwwe"
        minSdk = 32
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val compose_version = "1.4.3"
val nav_version = "2.7.0-beta01"
val glide_version = "2.1.11"
val koin_version = "3.4.0"
val ktor_version = "2.3.0"

dependencies {
    // firebase
    implementation("com.google.firebase:firebase-auth-ktx:22.0.0")
    implementation("com.google.firebase:firebase-storage-ktx:20.2.1")
    implementation("com.google.android.gms:play-services-auth:20.5.0")

    // koin
    implementation("io.insert-koin:koin-android:$koin_version")
    implementation("io.insert-koin:koin-androidx-compose:$koin_version")

    // ktor
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-auth-jvm:$ktor_version")

    // android
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")

    // compose
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("com.github.skydoves:landscapist-glide:$glide_version")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.compose.material3:material3:1.2.0-alpha02")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_version")
    implementation("androidx.compose.material:material-icons-extended:$compose_version")

    // stream chat SDK
    implementation("io.getstream:stream-chat-android-compose:5.12.0")

    // kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    // data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // flipper
    debugImplementation("com.facebook.flipper:flipper:0.201.0")
    debugImplementation("com.facebook.soloader:soloader:0.10.5")
    releaseImplementation("com.facebook.flipper:flipper-noop:0.201.0")
}