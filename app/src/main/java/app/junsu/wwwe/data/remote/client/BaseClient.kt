package app.junsu.wwwe.data.remote.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

abstract class BaseClient {
    protected val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

}
