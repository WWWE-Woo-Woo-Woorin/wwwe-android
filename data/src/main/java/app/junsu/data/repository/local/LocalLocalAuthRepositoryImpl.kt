package app.junsu.data.repository.local

import app.junsu.data.datasource.auth.LocalAuthDataSource
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
}
