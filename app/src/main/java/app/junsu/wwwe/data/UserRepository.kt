package app.junsu.wwwe.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import app.junsu.wwwe.data.local.ACCESS_TOKEN
import app.junsu.wwwe.data.local.ACCESS_TOKEN_EXP
import app.junsu.wwwe.data.local.REFRESH_TOKEN
import app.junsu.wwwe.data.remote.BASE_URL
import app.junsu.wwwe.model.user.SignInRequest
import app.junsu.wwwe.model.user.Token
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserRepository(
    private val httpClient: HttpClient,
    private val dataStore: DataStore<Preferences>,
) {
    suspend fun signIn(request: SignInRequest): Token {
        return httpClient.post("$BASE_URL/v1/users/signin") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun saveTokens(token: Token) {
        dataStore.edit {
            it[ACCESS_TOKEN] = token.accessToken
            it[ACCESS_TOKEN_EXP] = token.accessTokenExp
            it[REFRESH_TOKEN] = token.refreshToken
        }
    }

    /**
     * @return [Result] whether sign in success
     */
    suspend fun signInWithSavingToken(request: SignInRequest) {
        val token = this.signIn(request)
        this.saveTokens(token)
        println("TOKENTOKEN $token")
    }
}
