object AppConfigs {
    object NameSpaces {
        const val DOMAIN = "app.junsu.domain"
        const val DATA = "app.junsu.data"
        const val APP = "app.junsu.app"
        object Features {
            
        }
    }

    object DefaultConfigs {
        const val APPLICATION_ID = "app.junsu.wwwe"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"
        const val COMPILE_SDK_VERSION = 33
        const val MINIMUM_SDK_VERSION = 26
        const val TARGET_SDK_VERSION = 33
    }

    object BuildFeatures {
        const val IS_COMPOSE_ENABLED = false
        const val IS_DATA_BINDING_ENABLED = false
    }

    object BuildTypes {
        const val IS_MINIFY_ENABLED = false
    }

    object CompileOptions {
        val SOURCE_COMPATIBILITY = Versions.Java.JAVA_VERSION
        val TARGET_COMPATIBILITY = Versions.Java.JAVA_VERSION
    }

    object KotlinOptions {
        const val JVM_TARGET = "1.8"
    }
}
