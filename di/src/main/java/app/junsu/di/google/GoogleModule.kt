package app.junsu.di.google

import android.content.Context
import app.junsu.remote.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object GoogleModule {

    @Provides
    @Singleton
    private fun provideGoogleSignInClient(
        @ApplicationContext context: Context,
    ): GoogleSignInClient {

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
