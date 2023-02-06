package app.junsu.remote.interceptor

import android.content.Context
import android.util.Log
import app.junsu.remote.interceptor.model.HTTPMethod
import app.junsu.remote.interceptor.model.HTTPMethod.*
import app.junsu.remote.interceptor.model.ignoreRequests
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    @ApplicationContext private val context: Context,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val path = request.url.encodedPath
        val method = request.method.toEnum()

        if (ignoreRequests.any { it.path == path }) {
            chain.proceed(request)
        }

        val accessToken: String = runBlocking {
            "accessToken" // TODO
        }

        return chain.proceed(
            request.newBuilder().addHeader(
                "Authorization",
                accessToken,
            ).build(),
        )
    }
}

private fun String.toEnum(): HTTPMethod {
    return when (this) {
        "POST" -> POST
        "GET" -> GET
        "PUT" -> PUT
        "DELETE" -> DELETE
        "PATCH" -> PATCH
        else -> HTTPMethod.UNKNOWN.also {
            Log.e("HttpMethodParsing", "toEnum: $it")
        }
    }
}
