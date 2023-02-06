package app.junsu.remote.api.auth

import app.junsu.remote.model.auth.signin.SignInRequest
import app.junsu.remote.model.auth.signin.SignInResponse
import app.junsu.remote.model.auth.signup.SignUpRequest
import app.junsu.remote.util.PathVariables
import app.junsu.remote.util.URL
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

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
        @Path(PathVariables.EMAIL) email: String,
    )
}
