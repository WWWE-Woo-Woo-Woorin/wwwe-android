package app.junsu.di.datasource

import app.junsu.data.datasource.auth.RemoteAuthDataSource
import app.junsu.remote.datasource.auth.RemoteAuthDataSourceImpl
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
    protected abstract fun bindRemoteAuthDataSource(
        remoteAuthDataSourceImpl: RemoteAuthDataSourceImpl,
    ): RemoteAuthDataSource
}
