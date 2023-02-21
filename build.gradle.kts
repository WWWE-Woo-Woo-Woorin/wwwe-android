buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.Gradle.GRADLE_ANDROID)
        classpath(Plugins.Gradle.GRADLE_KOTLIN)
        classpath(Plugins.Gradle.GRADLE_HILT_ANDROID)
        classpath(Plugins.Gradle.GOOGLE_SERVICES)
        classpath(Plugins.Gradle.KOTLIN_SERIALIZATION)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
