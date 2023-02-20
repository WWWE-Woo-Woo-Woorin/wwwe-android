package app.junsu.local.datasource

import androidx.datastore.core.DataStore
import app.junsu.data._extension.epochSecondToLocalDateTime
import app.junsu.data._extension.toEpochSecond
import app.junsu.data.auth.datasource.LocalAuthDataSource
import app.junsu.model.common.Token
import app.junsu.model.preference.AppPreferencees
import app.junsu.model.preference.UserPreferences
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val userPreferencesDataStore: DataStore<UserPreferences>,
    private val appPreferencesDataStore: DataStore<AppPreferencees>,
) : LocalAuthDataSource {

    override suspend fun saveEmail(email: String) {

        require(isSignedIn())

        userPreferencesDataStore.updateData {
            UserPreferences.getDefaultInstance().copy(
                email = email,
            )
        }

        appPreferencesDataStore.updateData { oldPreferences ->
            AppPreferencees(
                isSignedIn = true,
            )
        }
    }

    override suspend fun fetchTokenFromStorage(): Token {

        require(isSignedIn())

        val accessToken = userPreferencesDataStore.data.first().accessToken

        val refreshToken = userPreferencesDataStore.data.first().refreshToken

        val accessTokenExpiresAt = userPreferencesDataStore.data.first().accessTokenExpiresAt

        return Token(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessTokenExpiresAt = accessTokenExpiresAt.epochSecondToLocalDateTime(),
        )
    }

    override suspend fun updateToken(
        token: Token,
    ) {

        require(isSignedIn())

        userPreferencesDataStore.updateData { oldUserPreferences ->
            UserPreferences(
                email = oldUserPreferences.email,
                accessToken = token.accessToken,
                refreshToken = token.refreshToken,
                accessTokenExpiresAt = token.accessTokenExpiresAt.toEpochSecond(),
            )
        }
    }

    override suspend fun clearToken() {

        require(isSignedIn())

        userPreferencesDataStore.updateData {
            UserPreferences.getDefaultInstance()
        }
    }

    override suspend fun signOut() {

        clearToken()

        appPreferencesDataStore.updateData {
            AppPreferencees.getDefaultInstance()
        }
    }

    override suspend fun isSignedIn(): Boolean {
        return appPreferencesDataStore.data.first().isSignedIn
    }
}
