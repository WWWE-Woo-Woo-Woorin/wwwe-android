package app.junsu.di.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import app.junsu.core_datastore.serializer.AppPreferencesSerializer
import app.junsu.core_datastore.serializer.UserPreferencesSerializer
import app.junsu.model.preference.AppPreferences
import app.junsu.model.preference.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataStoreModule {

    private const val PREFS_USER = "app_junsu.prefs_user"
    private const val PREFS_APP = "app_junsu.prefs_user"

    @Provides
    @Singleton
    fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
    ): DataStore<UserPreferences> {
        return DataStoreFactory.create(
            serializer = UserPreferencesSerializer()
        ) {
            File(
                "${context.cacheDir.path}/$PREFS_USER",
            )
        }
    }

    @Provides
    @Singleton
    fun providesAppPreferencesDataStore(
        @ApplicationContext context: Context,
    ): DataStore<AppPreferences> {
        return DataStoreFactory.create(
            serializer = AppPreferencesSerializer(),
        ) {
            File(
                "${context.cacheDir.path}/$PREFS_APP"
            )
        }
    }
}
