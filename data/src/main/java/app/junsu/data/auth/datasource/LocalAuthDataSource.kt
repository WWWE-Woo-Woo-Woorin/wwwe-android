package app.junsu.data.auth.datasource

import app.junsu.model.common.Token

interface LocalAuthDataSource {

    suspend fun saveEmail(
        email: String,
    )

    suspend fun fetchTokenFromStorage(): Token

    suspend fun updateToken(
        token: Token,
    )

    suspend fun clearToken()
}
