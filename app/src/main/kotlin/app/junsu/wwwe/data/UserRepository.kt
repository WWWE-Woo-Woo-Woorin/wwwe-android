package app.junsu.wwwe.data

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
    private val tokenFacade: TokenFacade,
) {
    suspend fun signIn(request: SignInRequest): Token {
        return httpClient.post("$BASE_URL/v1/users/signin") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /**
     * @return [Result] whether sign in success
     */
    suspend fun signInWithSavingTokenAndEmail(request: SignInRequest) {
        val token = this.signIn(request)
        tokenFacade.saveToken(token)
        tokenFacade.saveEmail(request.email)
    }

    suspend fun regenerateToken() {
        tokenFacade.regenerateToken()
    }
}
