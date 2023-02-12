package app.junsu.data.datasource.auth

import app.junsu.model.common.Token

interface LocalAuthDataSource {

    suspend fun fetchTokenFromStorage(): Token

    suspend fun saveToken(
        token: Token,
    )
}
