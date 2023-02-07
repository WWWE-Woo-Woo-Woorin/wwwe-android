package app.junsu.remote.datasource.auth

import android.content.Context
import app.junsu.data.datasource.auth.RemoteAuthDataSource
import app.junsu.model.Token
import app.junsu.remote.api.auth.AuthAPI
import app.junsu.remote.model.auth.signin.SignInRequest
import app.junsu.remote.model.auth.signup.SignUpRequest
import app.junsu.remote.util.HTTPHandler
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val authApi: AuthAPI,
    private val googleSignInClient: GoogleSignInClient,
    @ApplicationContext private val context: Context,
) : RemoteAuthDataSource {

    override suspend fun signIn(
        email: String,
        deviceToken: String?,
    ): Token {
        return HTTPHandler {
            authApi.signIn(
                SignInRequest(
                    email = email,
                    deviceToken = deviceToken,
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

/*    override suspend fun regenerateToken(accessToken: String): User {
        // TODO
    }*/
}
