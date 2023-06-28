package app.junsu.wwwe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    val sideEffectFlow = MutableStateFlow<MainSideEffect?>(null)

    fun regenerateToken() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = kotlin.runCatching {
                userRepository.regenerateToken()
            }

            sideEffectFlow.tryEmit(
                if (result.isSuccess) {
                    MainSideEffect.TokenAvailable
                } else {
                    MainSideEffect.TokenNotAvailable
                },
            )
        }
    }
}

sealed interface MainSideEffect {
    object TokenAvailable : MainSideEffect
    object TokenNotAvailable : MainSideEffect
}
