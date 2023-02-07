package app.junsu.remote.util

import android.content.Context
import app.junsu.remote.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class GoogleSignInClientProvider(
    private val context: Context,
) {
    operator fun invoke(): GoogleSignInClient {

        val googleSignInOptions = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN,
        ).requestIdToken(
            context.getString(R.string.default_web_client_id),
        ).requestEmail().build()

        return GoogleSignIn.getClient(
            context,
            googleSignInOptions,
        )
    }
}
