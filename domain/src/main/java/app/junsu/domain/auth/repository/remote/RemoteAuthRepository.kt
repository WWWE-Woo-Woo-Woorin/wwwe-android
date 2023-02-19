package app.junsu.domain.auth.repository.remote

import app.junsu.domain.auth.model.SignUpRequest
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
