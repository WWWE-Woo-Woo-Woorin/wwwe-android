package app.junsu.feature_google_sign_in.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.domain.usecase.auth.CheckEmailSignedInUseCase
import app.junsu.domain.usecase.auth.SignUpEmailUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val checkEmailSignedInUseCase: CheckEmailSignedInUseCase,
    private val signUpEmailUseCase: SignUpEmailUseCase,
    internal val googleSignInClient: GoogleSignInClient, // 이게 여기가 맞나..?
) : ViewModel() {

    private val _signInState = MutableSharedFlow<SignInState>()
    internal val signInState = _signInState.asSharedFlow()

    internal fun checkEmailSignedIn(
        email: String,
    ) {
        viewModelScope.launch {
            checkEmailSignedInUseCase(
                email = email,
            ).onSuccess {
                if (it) {
                    _signInState.emit(SignInState.SignedIn)
                } else {
                    signUpEmail(
                        email = email,
                    )
                }
            }
        }
    }

    private fun signUpEmail(
        email: String,
    ) {
        viewModelScope.launch {

            _signInState.emit(SignInState.Loading)

            signUpEmailUseCase(
                email = email,
            ).onSuccess {
                _signInState.emit(SignInState.AccountCreated)
            }
        }
    }
}

internal sealed interface SignInState {
    object Loading : SignInState
    object AccountCreated : SignInState
    object SignedIn : SignInState
}
