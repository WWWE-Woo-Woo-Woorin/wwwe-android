package app.junsu.di.repository

import app.junsu.data.repository.local.LocalLocalAuthRepositoryImpl
import app.junsu.data.repository.remote.RemoteAuthRepositoryImpl
import app.junsu.domain.repository.auth.local.LocalAuthRepository
import app.junsu.domain.repository.auth.remote.RemoteAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLocalAuthRepository(
        localAuthRepositoryImpl: LocalLocalAuthRepositoryImpl,
    ): LocalAuthRepository

    @Binds
    @Singleton
    abstract fun bindRemoteAuthRepository(
        remoteAuthRepositoryImpl: RemoteAuthRepositoryImpl,
    ): RemoteAuthRepository
}
