package app.junsu.feature_google_sign_in.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.domain.usecase.auth.local.SaveEmailUseCase
import app.junsu.domain.usecase.auth.remote.CheckEmailSignedInUseCase
import app.junsu.domain.usecase.auth.remote.SignUpEmailUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val saveEmailUseCase: SaveEmailUseCase,
    private val checkEmailSignedInUseCase: CheckEmailSignedInUseCase,
    private val signUpEmailUseCase: SignUpEmailUseCase,
    internal val googleSignInClient: GoogleSignInClient,
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

                    saveEmail(
                        email = email,
                    )
                }
            }
        }
    }

    private fun saveEmail(
        email: String,
    ) {
        viewModelScope.launch {
            saveEmailUseCase(
                email = email,
            )
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
