package app.junsu.feature_google_sign_in.viewmodel.googlesignin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.data.datasource.auth.RemoteAuthDataSource
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoogleSignInViewModel @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
    private val googleSignInClient: GoogleSignInClient,
) : ViewModel() {

    internal val googleSignInIntent = googleSignInClient.signInIntent

    private lateinit var account: GoogleSignInAccount

    internal fun signInWithGoogle() {
        viewModelScope.launch {
            kotlin.runCatching {

                val gso =

                    remoteAuthDataSource.signInWithGoogle()
            }
        }
    }
}
