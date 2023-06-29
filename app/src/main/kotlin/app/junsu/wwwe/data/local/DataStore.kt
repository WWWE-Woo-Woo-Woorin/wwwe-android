package app.junsu.wwwe.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "wwwe")

val ACCESS_TOKEN = stringPreferencesKey("access_token")
val ACCESS_TOKEN_EXP = stringPreferencesKey("access_token_exp")
val REFRESH_TOKEN = stringPreferencesKey("refresh_token")

val EMAIL = stringPreferencesKey("email")
