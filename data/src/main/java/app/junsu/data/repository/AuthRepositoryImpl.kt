package app.junsu.data.repository

import app.junsu.data.datasource.auth.LocalAuthDataSource
import app.junsu.data.datasource.auth.RemoteAuthDataSource
import app.junsu.domain.repository.auth.AuthRepository
import app.junsu.model.common.Token
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
    private val localAuthDataSource: LocalAuthDataSource,
) : AuthRepository {

    override suspend fun signIn(
        email: String,
        accessToken: String,
    ): Token {
        return remoteAuthDataSource.signIn(
            email = email,
            accessToken = accessToken,
        )
    }

    override suspend fun signUp(email: String, username: String, profileUrl: String?) {
        remoteAuthDataSource.signUp(
            email = email,
            username = username,
            profileUrl = profileUrl,
        )
    }

    override suspend fun signUpEmail(email: String) {
        remoteAuthDataSource.signUpEmail(
            email = email,
        )
    }

    override suspend fun fetchTokenFromStorage(): Token {
        return localAuthDataSource.fetchTokenFromStorage()
    }

    override suspend fun updateToken(token: Token) {
        localAuthDataSource.updateToken(
            token = token,
        )
    }

    override suspend fun clearToken() {
        localAuthDataSource.clearToken()
    }

    override suspend fun checkEmailSignedIn(email: String): Boolean {
        return remoteAuthDataSource.checkEmailSignedIn(
            email = email,
        )
    }
}
