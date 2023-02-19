package app.junsu.di.datasource

import app.junsu.data.auth.datasource.RemoteAuthDataSource
import app.junsu.remote.auth.datasource.RemoteAuthDataSourceImpl
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
    abstract fun bindRemoteAuthDataSource(
        remoteAuthDataSourceImpl: RemoteAuthDataSourceImpl,
    ): RemoteAuthDataSource
}
