package app.junsu.di.network

import app.junsu.remote.auth.api.AuthAPI
import app.junsu.remote.post.api.PostAPI
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

    @Provides
    @Singleton
    fun providesPostApi(
        retrofit: Retrofit,
    ): PostAPI {
        return retrofit.create(PostAPI::class.java)
    }
}
