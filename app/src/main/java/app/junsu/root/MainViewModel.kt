package app.junsu.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.domain.auth.usecase.remote.FetchUserInformationUseCase
import app.junsu.model.common.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val fetchUserInformationUseCase: FetchUserInformationUseCase,
) : ViewModel() {

    init {
        runBlocking {
            fetchUserInformation()
        }
    }

    internal lateinit var user: User

    private suspend fun fetchUserInformation() {
        user = User(
            "junjaboy@gmail.com",
            "junsupark",
            "https://lh3.googleusercontent.com/gx6srQNknQ6mYjVXm45wqZOPcCP7hshwYPEQlhSZcD4R417-rv8m45ht6AYoNXhrf_GR2J1Q8oGrAjGv=w544-h544-l90-rj"
        )
        /*user = withContext(viewModelScope.coroutineContext) {
            fetchUserInformationUseCase()
        }*/
    }
}
