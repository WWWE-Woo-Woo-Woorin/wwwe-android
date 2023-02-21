package app.junsu.root

import androidx.lifecycle.ViewModel
import app.junsu.domain.auth.usecase.local.CheckWhetherSignedInUseCase
import app.junsu.domain.auth.usecase.remote.FetchUserInformationUseCase
import app.junsu.model.common.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchUserInformationUseCase: FetchUserInformationUseCase,
    private val checkWhetherSignedInUseCase: CheckWhetherSignedInUseCase,
) : ViewModel() {

    init {
        runBlocking {
        }
    }

    internal var user: User = User(
        "junjaboy@gmail.com",
        "junsupark",
        "https://lh3.googleusercontent.com/gx6srQNknQ6mYjVXm45wqZOPcCP7hshwYPEQlhSZcD4R417-rv8m45ht6AYoNXhrf_GR2J1Q8oGrAjGv=w544-h544-l90-rj"
    )

    private suspend fun fetchUserInformation() {
        /*user = withContext(viewModelScope.coroutineContext) {
            fetchUserInformationUseCase()
        }*/
    }

    internal fun checkSignedIn(): Boolean {
        return runBlocking {
            checkWhetherSignedInUseCase()
        }
    }
}
