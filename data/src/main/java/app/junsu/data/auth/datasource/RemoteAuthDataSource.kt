package app.junsu.data.auth.datasource

import app.junsu.model.common.Token
import app.junsu.model.common.User

interface RemoteAuthDataSource {

    suspend fun signIn(
        email: String,
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

    suspend fun regenerateTokens(
        refreshToken: String,
    ): Token

    suspend fun fetchUserInformation(): User
}
