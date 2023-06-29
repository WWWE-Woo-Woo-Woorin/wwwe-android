package app.junsu.wwwe.di

import app.junsu.wwwe.MainViewModel
import app.junsu.wwwe.data.local.dataStore
import app.junsu.wwwe.data.remote.httpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    includes(
        communityModule,
        userModule,
        postModule,
    )

    single { httpClient }
    single { androidContext().dataStore }

    viewModel { MainViewModel(get()) }
    viewModelOf(::MainViewModel)
}
