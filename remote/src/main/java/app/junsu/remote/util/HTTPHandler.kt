package app.junsu.remote.util

import app.junsu.domain.status.client.ClientStatus.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException

object HTTPHandler {
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

    @PublishedApi
    internal fun HttpException.handleHttpException(): Nothing {
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
