package app.junsu.data.datasource.auth

import app.junsu.model.Token

interface LocalAuthDataSource {

    fun fetchTokenFromStorage(): Token

    fun saveToken(
        token: Token,
    )
}
