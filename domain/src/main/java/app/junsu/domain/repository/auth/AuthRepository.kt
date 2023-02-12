package app.junsu.domain.repository.auth

import app.junsu.model.common.Token

interface AuthRepository {

    suspend fun signIn(
        email: String,
    )

    suspend fun signUp(
        email: String,
        username: String,
        profileUrl: String?,
    )

    suspend fun signUpEmail(
        email: String,
    )

    suspend fun fetchTokenFromStorage(): Token

    suspend fun updateToken(
        token: Token,
    )

    suspend fun checkEmailSignedIn(
        email: String,
    ): Boolean
}
