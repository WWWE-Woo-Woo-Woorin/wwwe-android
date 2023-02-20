package app.junsu.data.auth.repository.local

import app.junsu.data.auth.datasource.LocalAuthDataSource
import app.junsu.domain.auth.repository.LocalAuthRepository
import app.junsu.model.common.Token
import javax.inject.Inject

class LocalLocalAuthRepositoryImpl @Inject constructor(
    private val localAuthDataSource: LocalAuthDataSource,
) : LocalAuthRepository {


    override suspend fun saveEmail(email: String) {
        localAuthDataSource.saveEmail(
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

    override suspend fun signOut() {
        return localAuthDataSource.signOut()
    }

    override suspend fun isSignedIn(): Boolean {
        return localAuthDataSource.isSignedIn()
    }
}
