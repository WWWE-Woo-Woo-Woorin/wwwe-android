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
        userPreferencesDataStore.updateData {
            UserPreferences.getDefaultInstance().copy(
                email = email,
            )
        }
    }

    override suspend fun fetchTokenFromStorage(): Token {

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
        userPreferencesDataStore.updateData {
            UserPreferences.getDefaultInstance()
        }
    }

    override suspend fun signOut() {
        clearToken()
        
    }

    override suspend fun isSignedIn(): Boolean {
        TODO("Not yet implemented")
    }
}
