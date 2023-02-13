package app.junsu.local.datasource

import androidx.datastore.core.DataStore
import app.junsu.data.datasource.auth.LocalAuthDataSource
import app.junsu.data.extension.epochSecondToLocalDateTime
import app.junsu.data.extension.toEpochSecond
import app.junsu.model.common.Token
import app.junsu.model.preference.UserPreferences
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val userPreferencesDataStore: DataStore<UserPreferences>,
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
}
