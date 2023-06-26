package app.junsu.wwwe.di

import app.junsu.wwwe.ui.auth.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val signInModule = module {

    viewModel { SignInViewModel() }
    viewModelOf(::SignInViewModel)
}
