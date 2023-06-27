package app.junsu.wwwe.ui.auth.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.UserRepository
import app.junsu.wwwe.model.user.SignInRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    val sideEffectFlow = MutableStateFlow<SignInSideEffect?>(null)
    fun signIn(request: SignInRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                userRepository.signIn(request)
            }.onSuccess {
                sideEffectFlow.tryEmit(SignInSideEffect.SignInSuccess)
            }.onFailure {
                sideEffectFlow.tryEmit(SignInSideEffect.SignInFailure)
            }
        }
    }
}

sealed interface SignInSideEffect {
    object SignInSuccess : SignInSideEffect
    object SignInFailure : SignInSideEffect
    object UserNotFound : SignInSideEffect
}
