package app.junsu.remote.api.auth

import app.junsu.remote.model.auth.signin.SignInRequest
import app.junsu.remote.model.auth.signin.SignInResponse
import app.junsu.remote.util.URL
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST(URL.Auth.SIGN_IN)
    suspend fun signIn(
        @Body request: SignInRequest,
    ): SignInResponse
}
