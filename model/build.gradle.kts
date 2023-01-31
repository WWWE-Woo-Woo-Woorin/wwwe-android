plugins {
    id(Plugins.Java.JAVA_LIBRARY)
    id(Plugins.Kotlin.KOTLIN_JVM)
}

java {
    sourceCompatibility = AppConfigs.CompileOptions.SOURCE_COMPATIBILITY
    targetCompatibility = AppConfigs.CompileOptions.TARGET_COMPATIBILITY
}