package app.junsu.di.datasource

import app.junsu.data.auth.datasource.LocalAuthDataSource
import app.junsu.local.datasource.LocalAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private abstract class LocalDataSourceModule {

    @Singleton
    @Binds
    abstract fun bindLocalAuthDataSource(
        localAuthDataSourceImpl: LocalAuthDataSourceImpl,
    ): LocalAuthDataSource
}
