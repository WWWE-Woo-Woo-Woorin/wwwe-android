package app.junsu.wwwe.di

import app.junsu.wwwe.ui.main.createpost.CreatePostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val createPostModule = module {
    viewModel { CreatePostViewModel() }
    viewModelOf(::CreatePostViewModel)
}
