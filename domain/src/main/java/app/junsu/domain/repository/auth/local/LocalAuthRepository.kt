package app.junsu.domain.repository.auth.local

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
}
