package app.junsu.domain.repository.auth.remote

import app.junsu.domain.param.auth.SignUpRequest
import app.junsu.model.common.Token
import app.junsu.model.common.User

interface RemoteAuthRepository {

    suspend fun signIn(
        email: String,
    ): Token

    suspend fun signUp(
        request: SignUpRequest,
    )

    suspend fun signUpEmail(
        email: String,
    )

    suspend fun checkEmailSignedIn(
        email: String,
    ): Boolean

    suspend fun fetchUserInformation(): User
}
