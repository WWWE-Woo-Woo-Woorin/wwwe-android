package app.junsu.wwwe.di

import app.junsu.wwwe.ui.main.home.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val settingsModule = module {
    viewModel { SettingsViewModel() }
    viewModelOf(::SettingsViewModel)
}
