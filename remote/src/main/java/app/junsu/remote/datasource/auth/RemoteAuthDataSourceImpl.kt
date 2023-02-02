package app.junsu.remote.datasource.auth

import app.junsu.data.datasource.auth.RemoteAuthDataSource
import app.junsu.model.Token
import app.junsu.model.User
import app.junsu.remote.api.auth.AuthAPI
import app.junsu.remote.model.auth.signin.SignInRequest
import app.junsu.remote.util.HTTPHandler
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val authApi: AuthAPI,
) : RemoteAuthDataSource {

    override suspend fun signIn(email: String): Token {
        return HTTPHandler {
            authApi.signIn(
                request = SignInRequest(
                    email = email,
                )
            )
        }.toToken()
    }

/*    override suspend fun regenerateToken(accessToken: String): User {
        // TODO
    }*/
}