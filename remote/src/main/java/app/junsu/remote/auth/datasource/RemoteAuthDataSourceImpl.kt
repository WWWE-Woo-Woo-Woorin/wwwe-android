package app.junsu.remote.auth.datasource

import app.junsu.data.auth.datasource.RemoteAuthDataSource
import app.junsu.model.common.Token
import app.junsu.model.common.User
import app.junsu.remote.auth.api.AuthAPI
import app.junsu.remote.auth.model.signin.SignInRequest
import app.junsu.remote.auth.model.signup.SignUpRequest
import app.junsu.remote._util.HTTPHandler
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val authApi: AuthAPI,
) : RemoteAuthDataSource {

    override suspend fun signIn(
        email: String,
    ): Token {
        return HTTPHandler {
            authApi.signIn(
                SignInRequest(
                    email = email,
                ),
            )
        }.toToken()
    }

    override suspend fun signUp(email: String, username: String, profileUrl: String?) {
        return HTTPHandler {
            authApi.signUp(
                request = SignUpRequest(
                    email = email,
                    username = username,
                    profileUrl = profileUrl,
                ),
            )
        }
    }

    override suspend fun signUpEmail(email: String) {
        return HTTPHandler {
            authApi.signUpEmail(
                email = email,
            )
        }
    }

    override suspend fun checkEmailSignedIn(email: String): Boolean {
        return HTTPHandler {
            authApi.checkEmailSignedIn(
                email = email,
            )
        }
    }

    override suspend fun regenerateTokens(refreshToken: String): Token {
        return HTTPHandler {
            authApi.regenerateTokens(
                refreshToken = refreshToken,
            )
        }.toToken()
    }

    override suspend fun fetchUserInformation(): User {
        return HTTPHandler {
            authApi.fetchUserInformation()
        }.toUser()
    }
}
