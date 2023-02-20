package app.junsu.domain.auth.repository

import app.junsu.model.common.Token

interface LocalAuthRepository {

    suspend fun saveEmail(
        email: String,
    )

    suspend fun fetchTokenFromStorage(): Token

    suspend fun updateToken(
        token: Token,
    )

    suspend fun clearToken()

    suspend fun signOut()

    suspend fun isSignedIn(): Boolean
}
