package app.junsu.domain.repository.auth

import app.junsu.model.common.Token

interface AuthRepository {

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

    suspend fun saveEmail(
        email: String,
    )

    suspend fun fetchTokenFromStorage(): Token

    suspend fun updateToken(
        token: Token,
    )

    suspend fun clearToken()

    suspend fun checkEmailSignedIn(
        email: String,
    ): Boolean
}
