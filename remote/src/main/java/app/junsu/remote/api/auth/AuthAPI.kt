package app.junsu.remote.api.auth

import app.junsu.remote.model.auth.signin.SignInRequest
import app.junsu.remote.model.auth.signin.SignInResponse
import app.junsu.remote.model.auth.signup.SignUpRequest
import app.junsu.remote.util.RequestParams
import app.junsu.remote.util.URL
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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
}
