package app.junsu.feature_google_sign_in.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.domain.usecase.auth.CheckEmailSignedInUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val checkEmailSignedInUseCase: CheckEmailSignedInUseCase,
    private val googleSignInClient: GoogleSignInClient,
) : ViewModel() {

    internal val googleSignInIntent = googleSignInClient.signInIntent

    internal lateinit var account: GoogleSignInAccount

    internal fun checkEmailSignedIn() {
        if (!this::account.isInitialized) {
            // todo throw account not initialized exception
        }
        viewModelScope.launch {
            checkEmailSignedInUseCase(
                email = account.email!!,
            ).onSuccess {
                if (!it) {
                    // todo if email not exists
                } else {
                    // todo if email exists
                }
            }
        }
    }
}
