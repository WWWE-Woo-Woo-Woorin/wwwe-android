package app.junsu.wwwe.data.remote.client

import app.junsu.wwwe.model.PostType
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DataConversion
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

val httpClient: HttpClient by lazy {
    HttpClient(CIO) {
        expectSuccess = true

        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(DataConversion) {
            convert {
                decode { values ->
                    values.single().let {
                        when (it) {
                            "DEFAULT" -> PostType.DEFAULT
                            "MAJOR" -> PostType.MAJOR
                            "CLUB" -> PostType.CLUB
                            else -> throw IllegalStateException()
                        }
                    }
                }
                encode {
                    when (it as PostType) { // when type-casting removed, the compiler shows that has syntax error
                        PostType.DEFAULT -> listOf("DEFAULT")
                        PostType.MAJOR -> listOf("MAJOR")
                        PostType.CLUB -> listOf("CLUB")
                    }
                }
            }
        }
    }
}
