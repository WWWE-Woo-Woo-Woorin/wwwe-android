package app.junsu.wwwe.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

class HttpRequestHelper {
    private val client: HttpClient = HttpClient(CIO)


}
