package app.junsu.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.domain.usecase.auth.remote.FetchUserInformationUseCase
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
        user = withContext(viewModelScope.coroutineContext) {
            fetchUserInformationUseCase()
        }
    }
}
