package app.junsu.data.repository.remote

import app.junsu.data.datasource.auth.RemoteAuthDataSource
import app.junsu.domain.repository.auth.remote.RemoteAuthRepository
import app.junsu.model.common.Token
import app.junsu.model.common.User
import javax.inject.Inject

class RemoteAuthRepositoryImpl @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
) : RemoteAuthRepository {

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

    override suspend fun checkEmailSignedIn(email: String): Boolean {
        return remoteAuthDataSource.checkEmailSignedIn(
            email = email,
        )
    }

    override suspend fun fetchUserInformation(): User {
        return remoteAuthDataSource.fetchUserInformation()
    }
}
