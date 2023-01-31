package app.junsu.data.datasource.auth

import app.junsu.model.Token
import app.junsu.model.User

interface RemoteAuthDataSource {

    suspend fun signIn(
        email: String,
    ): Token

    suspend fun fetchToken(
        accessToken: String,
    ): User
}
