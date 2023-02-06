package app.junsu.data.repository

import app.junsu.data.datasource.auth.RemoteAuthDataSource
import app.junsu.domain.repository.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
) : AuthRepository {

    override suspend fun signIn(email: String) {
        //todo
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

    override suspend fun fetchToken(accessToken: String) {
        //todo
    }

    override suspend fun saveToken(accessToken: String) {
        //todo
    }
}
