package app.junsu.wwwe.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import app.junsu.wwwe.data.local.ACCESS_TOKEN
import app.junsu.wwwe.data.local.ACCESS_TOKEN_EXP
import app.junsu.wwwe.data.local.EMAIL
import app.junsu.wwwe.data.local.REFRESH_TOKEN
import app.junsu.wwwe.data.remote.BASE_URL
import app.junsu.wwwe.model.user.SignInRequest
import app.junsu.wwwe.model.user.Token
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import java.io.IOException
import kotlinx.coroutines.flow.first

class TokenFacade(
    private val httpClient: HttpClient,
    private val dataStore: DataStore<Preferences>,
) {
    suspend fun regenerateToken(): Token {
        val email = this.findEmail() ?: throw IOException()
        return httpClient.put("$BASE_URL/v1/users/token") {
            contentType(ContentType.Application.Json)
            bearerAuth(this@TokenFacade.findRefreshTokenOrThrow())
            setBody(SignInRequest(email = email))
        }.body()
    }

    suspend fun saveToken(token: Token) {
        dataStore.edit {
            it[ACCESS_TOKEN] = token.accessToken
            it[ACCESS_TOKEN_EXP] = token.accessTokenExp
            it[REFRESH_TOKEN] = token.refreshToken
        }
    }

    suspend fun regenerateAndSaveToken(): Token {
        val regeneratedToken = this.regenerateToken()
        return regeneratedToken.also { this.saveToken(it) }
    }

    suspend fun findToken(): Token? {
        val accessToken = this.findAccessToken() ?: return null
        val accessTokenExp = this.findAccessTokenExp() ?: return null
        val refreshToken = this.findRefreshToken() ?: return null

        return Token(
            accessToken = accessToken,
            accessTokenExp = accessTokenExp,
            refreshToken = refreshToken,
        )
    }

    suspend fun saveEmail(email: String) {
        dataStore.edit {
            it[EMAIL] = email
        }
    }

    suspend fun findEmail(): String? {
        return dataStore.data.first()[EMAIL]
    }

    suspend fun findAccessToken(): String? {
        return dataStore.data.first()[ACCESS_TOKEN]
    }

    suspend fun findAccessTokenExp(): String? {
        return dataStore.data.first()[ACCESS_TOKEN_EXP]
    }

    suspend fun findRefreshToken(): String? {
        return dataStore.data.first()[REFRESH_TOKEN]
    }

    suspend fun findAccessTokenOrThrow(): String {
        return this.findAccessToken() ?: throw IOException()
    }

    suspend fun findRefreshTokenOrThrow(): String {
        return this.findRefreshToken() ?: throw IOException()
    }

    suspend fun findAccessTokenOrRegenerate(): String {
        return try {
            this.findAccessTokenOrThrow()
        } catch (e: IOException) {
            regenerateAndSaveToken().accessToken
        }
    }
}
