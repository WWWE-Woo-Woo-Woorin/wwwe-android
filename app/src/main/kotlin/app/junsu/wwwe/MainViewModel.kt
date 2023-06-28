package app.junsu.wwwe

import androidx.lifecycle.ViewModel
import app.junsu.wwwe.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking

class MainViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    val sideEffectFlow = MutableStateFlow<MainSideEffect?>(null)

    fun regenerateToken(): Boolean {
        return runBlocking {
            val result = kotlin.runCatching {
                userRepository.regenerateToken()
            }.onFailure {
                it.printStackTrace()
            }

            val success = result.isSuccess

            sideEffectFlow.tryEmit(
                if (success) {
                    MainSideEffect.TokenAvailable
                } else {
                    MainSideEffect.TokenNotAvailable
                },
            )

            return@runBlocking success
        }
    }
}

sealed interface MainSideEffect {
    object TokenAvailable : MainSideEffect
    object TokenNotAvailable : MainSideEffect
}
