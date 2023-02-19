package app.junsu.data.auth.repository.remote

import app.junsu.data.auth.datasource.RemoteAuthDataSource
import app.junsu.domain.auth.model.SignUpRequest
import app.junsu.domain.auth.repository.remote.RemoteAuthRepository
import app.junsu.model.common.Token
import app.junsu.model.common.User
import javax.inject.Inject

class RemoteAuthRepositoryImpl @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
) : RemoteAuthRepository {

    override suspend fun signIn(
        email: String,
    ): Token {
        return remoteAuthDataSource.signIn(
            email = email,
        )
    }

    override suspend fun signUp(
        request: SignUpRequest,
    ) {
        remoteAuthDataSource.signUp(
            email = request.email,
            username = request.username,
            profileUrl = request.profileUrl,
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
