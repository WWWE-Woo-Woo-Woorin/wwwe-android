package app.junsu.wwwe.di

import app.junsu.wwwe.data.CommunityRepository
import app.junsu.wwwe.data.CommunityRepositoryImpl
import app.junsu.wwwe.ui.home.community.CommunityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single<CommunityRepository> { CommunityRepositoryImpl() }

    viewModel { CommunityViewModel(get()) }
}
