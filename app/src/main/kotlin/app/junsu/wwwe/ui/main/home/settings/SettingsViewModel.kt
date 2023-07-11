package app.junsu.wwwe.ui.main.home.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    val sideEffectFlow = MutableStateFlow<SettingsSideEffect?>(null)

    fun signOut() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = kotlin.runCatching { userRepository.signOut() }
            sideEffectFlow.tryEmit(
                if (result.isSuccess) {
                    SettingsSideEffect.SignInSuccess
                } else {
                    SettingsSideEffect.SignInFailure
                },
            )
        }
    }
}

sealed interface SettingsSideEffect {
    object SignInSuccess : SettingsSideEffect
    object SignInFailure : SettingsSideEffect
}
