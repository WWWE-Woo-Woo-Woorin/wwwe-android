package app.junsu.wwwe.di

import app.junsu.wwwe.data.PostRepository
import app.junsu.wwwe.ui.main.createpost.CreatePostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val postModule = module {
    single { PostRepository(get()) }

    viewModel { CreatePostViewModel() }
    viewModelOf(::CreatePostViewModel)
}
