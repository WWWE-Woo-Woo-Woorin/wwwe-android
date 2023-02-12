package app.junsu.data.datasource.auth

import app.junsu.model.common.Token

interface LocalAuthDataSource {

    fun fetchTokenFromStorage(): Token

    fun saveToken(
        token: Token,
    )
}
