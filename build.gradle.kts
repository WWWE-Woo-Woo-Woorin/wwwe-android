buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.Gradle.GRADLE_ANDROID)
        classpath(Plugins.Gradle.GRADLE_KOTLIN)
        classpath(Plugins.Gradle.GRADLE_HILT_ANDROID)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
