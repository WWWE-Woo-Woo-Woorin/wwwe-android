package app.junsu.domain.repository.auth.remote

import app.junsu.model.common.Token

interface RemoteAuthRepository {

    suspend fun signIn(
        email: String,
        accessToken: String,
    ): Token

    suspend fun signUp(
        email: String,
        username: String,
        profileUrl: String?,
    )

    suspend fun signUpEmail(
        email: String,
    )

    suspend fun checkEmailSignedIn(
        email: String,
    ): Boolean

    suspend fun fetchUserInformation(): UserInformation
}
