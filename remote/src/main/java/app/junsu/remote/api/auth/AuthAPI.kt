package app.junsu.remote.api.auth

import app.junsu.remote.model.auth.signin.SignInRequest
import app.junsu.remote.model.auth.signin.SignInResponse
import app.junsu.remote.model.auth.signup.SignUpRequest
import app.junsu.remote.model.auth.token.RegenerateTokenResponse
import app.junsu.remote.util.RequestParams
import app.junsu.remote.util.URL
import retrofit2.http.*

interface AuthAPI {

    @POST(URL.Auth.SIGN_IN)
    suspend fun signIn(
        @Body request: SignInRequest,
    ): SignInResponse

    @POST(URL.Auth.SIGN_UP)
    suspend fun signUp(
        @Body request: SignUpRequest,
    )

    @POST(URL.Auth.SignUp.SIGNUP_EMAIL)
    suspend fun signUpEmail(
        @Query(RequestParams.EMAIL) email: String,
    )

    @GET(URL.Auth.Check.EMAIL_SIGNED_IN)
    suspend fun checkEmailSignedIn(
        @Query(RequestParams.EMAIL) email: String,
    ): Boolean

    @PUT(URL.Auth.REGENERATE_TOKEN)
    suspend fun regenerateTokens(
        @Header(value = "Authorization") refreshToken: String,
    ): RegenerateTokenResponse
}
