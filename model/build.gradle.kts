plugins {
    id(Plugins.Java.JAVA_LIBRARY)
    id(Plugins.Kotlin.KOTLIN_JVM)
    id(Plugins.Kotlin.SERIALIZATION)
}

java {
    sourceCompatibility = AppConfigs.CompileOptions.SOURCE_COMPATIBILITY
    targetCompatibility = AppConfigs.CompileOptions.TARGET_COMPATIBILITY
}

dependencies {

    implementation(Dependencies.Kotlin.SERIALIZATION)
}
