package app.junsu.di.repository

import app.junsu.data.auth.repository.local.LocalLocalAuthRepositoryImpl
import app.junsu.data.auth.repository.remote.RemoteAuthRepositoryImpl
import app.junsu.data.post.repository.PostRepositoryImpl
import app.junsu.domain.auth.repository.LocalAuthRepository
import app.junsu.domain.auth.repository.remote.RemoteAuthRepository
import app.junsu.domain.post.repository.PostRepository
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
    abstract fun bindsLocalAuthRepository(
        localAuthRepositoryImpl: LocalLocalAuthRepositoryImpl,
    ): LocalAuthRepository

    @Binds
    @Singleton
    abstract fun bindsRemoteAuthRepository(
        remoteAuthRepositoryImpl: RemoteAuthRepositoryImpl,
    ): RemoteAuthRepository

    @Binds
    @Singleton
    abstract fun bindsPostRepository(
        postRepositoryImpl: PostRepositoryImpl,
    ): PostRepository
}
