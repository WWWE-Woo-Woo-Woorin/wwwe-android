package app.junsu.wwwe.di

import app.junsu.wwwe.data.remote.client.httpClient
import org.koin.dsl.module

val appModule = module {
    includes(
        communityModule,
        userModule,
        postModule,
    )
    single { httpClient }
}
