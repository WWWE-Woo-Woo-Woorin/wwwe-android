package app.junsu.local.datasource

import androidx.datastore.core.DataStore
import app.junsu.data.datasource.auth.LocalAuthDataSource
import app.junsu.model.common.Token
import app.junsu.model.preference.UserPreferences
import kotlinx.coroutines.flow.first
import java.time.LocalDateTime
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val userPreferencesDataStore: DataStore<UserPreferences>,
) : LocalAuthDataSource {

    override suspend fun fetchTokenFromStorage(): Token {

        val accessToken = userPreferencesDataStore.data.first().accessToken

        val refreshToken = userPreferencesDataStore.data.first().refreshToken

        val accessTokenExpiresAt = userPreferencesDataStore.data.first().accessTokenExpiresAt

        return Token(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessTokenExpiresAt = LocalDateTime.parse(accessTokenExpiresAt),
        )
    }

    override suspend fun updateToken(
        token: Token,
    ) {
        userPreferencesDataStore.updateData {
            UserPreferences(
                accessToken = token.accessToken,
                refreshToken = token.refreshToken,
                accessTokenExpiresAt = token.accessTokenExpiresAt.toString(),
            )
        }
    }

    override suspend fun clearToken() {
        userPreferencesDataStore.updateData {
            UserPreferences.getDefaultInstance()
        }
    }
}
