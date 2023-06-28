package app.junsu.wwwe.di

import app.junsu.wwwe.ui.main.home.community.CommunityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val communityModule = module {
    viewModel { CommunityViewModel(get()) }
    viewModelOf(::CommunityViewModel)
}
