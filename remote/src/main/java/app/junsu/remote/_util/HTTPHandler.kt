package app.junsu.remote._util

import app.junsu.remote._status.client.ClientStatus.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException

internal object HTTPHandler {
    suspend inline operator fun <T> invoke(
        crossinline block: suspend () -> T,
    ): T {
        return try {
            withContext(Dispatchers.IO) {
                block()
            }
        } catch (e: HttpException) {
            e.handleHttpException()
        } catch (e: UnknownHostException) {
            throw NoInternet()
        }
    }

    private fun HttpException.handleHttpException(): Nothing {
        throw when (code()) {
            400 -> BadRequest()
            401 -> Unauthorized()
            403 -> Forbidden()
            404 -> NotFound()
            405 -> MethodNotAllowed()
            409 -> Conflict()
            429 -> TooManyRequests()
            else -> Unknown()
        }
    }
}
