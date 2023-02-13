package app.junsu.remote.interceptor

import app.junsu.data.datasource.auth.LocalAuthDataSource
import app.junsu.domain.status.client.ClientStatus.Unauthorized
import app.junsu.remote.BuildConfig
import app.junsu.remote.interceptor.model.ignoreRequests
import app.junsu.remote.interceptor.model.toHttpMethod
import app.junsu.remote.model.auth.token.RegenerateTokenResponse
import app.junsu.remote.util.URL
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val localAuthDataSource: LocalAuthDataSource,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val path = request.url.encodedPath
        val method = request.method.toHttpMethod()

        if (ignoreRequests.any { (it.path == path) && (it.method == method) }) {
            return chain.proceed(request)
        }

        val accessTokenExpiresAt = fetchAccessTokenExpirationTime()

        val currentDeviceTime = LocalDateTime.now(
            ZoneId.systemDefault(),
        )

        if (accessTokenExpiresAt.isBefore(currentDeviceTime)) {
            regenerateTokens()
        } else {
            throw Unauthorized()
        }

        val accessToken = fetchAccessToken()

        return chain.proceed(
            request.newBuilder().addHeader(
                "Authorization",
                accessToken,
            ).build(),
        )
    }

    private fun regenerateTokens() {

        val refreshToken = fetchRefreshToken()

        val tokenRefreshRequest = Request.Builder().url(
            BuildConfig.BASE_URL + URL.Auth.REGENERATE_TOKEN,
        ).addHeader(
            "Authorization", refreshToken,
        ).build()

        val tokenRefreshResponse = OkHttpClient().newCall(
            tokenRefreshRequest,
        ).execute()

        if (tokenRefreshResponse.isSuccessful) {

            val newToken = Gson().fromJson(
                tokenRefreshResponse.body!!.string(),
                RegenerateTokenResponse::class.java,
            ).toToken()

            runBlocking {
                localAuthDataSource.updateToken(
                    token = newToken,
                )
            }
        } else throw Unauthorized()
    }

    private fun fetchAccessToken(): String {
        return runBlocking {
            localAuthDataSource.fetchTokenFromStorage().accessToken
        }
    }

    private fun fetchRefreshToken(): String {
        return runBlocking {
            localAuthDataSource.fetchTokenFromStorage().refreshToken
        }
    }

    private fun fetchAccessTokenExpirationTime(): LocalDateTime {
        return runBlocking {
            localAuthDataSource.fetchTokenFromStorage().accessTokenExpiresAt
        }
    }
}
