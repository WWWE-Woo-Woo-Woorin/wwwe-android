package app.junsu.remote.interceptor

import app.junsu.data.datasource.auth.LocalAuthDataSource
import app.junsu.remote.interceptor.model.HTTPMethod
import app.junsu.remote.interceptor.model.ignoreRequests
import app.junsu.remote.interceptor.model.toHttpMethod
import app.junsu.remote.util.URL
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val localAuthDataSource: LocalAuthDataSource,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val path = request.url.encodedPath
        val method = request.method.toHttpMethod()

        if (ignoreRequests.any { it.path == path }) {
            chain.proceed(request)
        }

        val accessToken: String = runBlocking {
            localAuthDataSource.fetchTokenFromStorage().accessToken
        }

        return chain.proceed(
            request.newBuilder().addHeader(
                "Authorization",
                accessToken,
            ).build(),
        )
    }
}
