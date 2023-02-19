package app.junsu.di.network

import android.util.Log
import app.junsu.data.auth.datasource.LocalAuthDataSource
import app.junsu.remote.BuildConfig
import app.junsu.remote.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthInterceptor(
        localAuthDataSource: LocalAuthDataSource,
    ): AuthInterceptor {
        return AuthInterceptor(
            localAuthDataSource = localAuthDataSource,
        )
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { log ->
            Log.i("Http Log", log)
        }.setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE,
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(
            authInterceptor,
        ).addNetworkInterceptor(
            httpLoggingInterceptor,
        ).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
