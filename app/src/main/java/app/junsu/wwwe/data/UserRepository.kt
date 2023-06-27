package app.junsu.wwwe.data

import app.junsu.wwwe.data.remote.client.BASE_URL
import app.junsu.wwwe.model.user.SignInRequest
import app.junsu.wwwe.model.user.Token
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class UserRepository(
    private val httpClient: HttpClient,
) {
    suspend fun signIn(request: SignInRequest): Token {
        return httpClient.post("$BASE_URL/v1/users/signin") { setBody(request) }.body()
    }
}
