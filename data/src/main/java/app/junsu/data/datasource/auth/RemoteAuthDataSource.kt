package app.junsu.data.datasource.auth

import app.junsu.model.Token

interface RemoteAuthDataSource {

    suspend fun signIn(
        email: String,
        deviceToken: String?,
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

    /* suspend fun regenerateToken(
         accessToken: String,
     ): User*/
}
