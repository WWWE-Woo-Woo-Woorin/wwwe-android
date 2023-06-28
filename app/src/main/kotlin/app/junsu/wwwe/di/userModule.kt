package app.junsu.wwwe.di

import app.junsu.wwwe.data.TokenFacade
import app.junsu.wwwe.data.UserRepository
import app.junsu.wwwe.ui.auth.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val userModule = module {
    single { UserRepository(get(), get()) }
    single { TokenFacade(get(), get()) }

    viewModel { SignInViewModel(get()) }
    viewModelOf(::SignInViewModel)
}
