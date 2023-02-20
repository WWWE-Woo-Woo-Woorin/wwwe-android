package app.junsu.di.network

import app.junsu.remote.auth.api.AuthAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object APIModule {

    @Provides
    @Singleton
    fun providesAuthApi(
        retrofit: Retrofit,
    ): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }
}
