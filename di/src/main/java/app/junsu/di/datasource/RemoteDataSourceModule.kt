package app.junsu.di.datasource

import app.junsu.data.auth.datasource.RemoteAuthDataSource
import app.junsu.data.post.datasource.PostDataSource
import app.junsu.remote.auth.datasource.RemoteAuthDataSourceImpl
import app.junsu.remote.post.datasource.PostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private abstract class RemoteDataSourceModule {

    @Singleton
    @Binds
    abstract fun bindsRemoteAuthDataSource(
        remoteAuthDataSourceImpl: RemoteAuthDataSourceImpl,
    ): RemoteAuthDataSource

    @Singleton
    @Binds
    abstract fun bindsPostDataSource(
        postDataSourceImpl: PostDataSourceImpl,
    ): PostDataSource
}
