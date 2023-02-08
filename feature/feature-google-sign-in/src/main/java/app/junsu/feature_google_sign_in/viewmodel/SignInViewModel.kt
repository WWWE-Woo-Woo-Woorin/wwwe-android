package app.junsu.feature_google_sign_in.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _email = MutableLiveData<String>()
    internal val email: LiveData<String>
        get() = _email

    internal var account: GoogleSignInAccount? = null
        set(value) {
            field = value.also {
                Log.e("ViewModel", ": $it")
            }
        }

    internal fun checkEmailSignedIn(
        email: String,
    ) {
        /*if (!this::account.isInitialized) {
            // todo email not initialized
        }*/
        viewModelScope.launch {
            checkEmailSignedInUseCase(
                email = email,
            ).onSuccess {

            }
        }
    }
}
