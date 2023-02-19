package app.junsu.remote.auth.api

import app.junsu.remote.auth.model.FetchUserInformationResponse
import app.junsu.remote.auth.model.SignInRequest
import app.junsu.remote.auth.model.TokenResponse
import app.junsu.remote.auth.model.SignUpRequest
import app.junsu.remote.auth.model.RegenerateTokenResponse
import app.junsu.remote._util.RequestParams
import app.junsu.remote._common.URL
import retrofit2.http.*

interface AuthAPI {

    @POST(URL.Auth.SIGN_IN)
    suspend fun signIn(
        @Body request: SignInRequest,
    ): TokenResponse

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

    @GET(URL.Auth.FETCH_USER_INFORMATION)
    suspend fun fetchUserInformation(): FetchUserInformationResponse
}
