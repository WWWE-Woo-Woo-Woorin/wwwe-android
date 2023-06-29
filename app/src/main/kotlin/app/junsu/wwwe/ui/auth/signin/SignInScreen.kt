package app.junsu.wwwe.ui.auth.signin

import android.app.Activity.RESULT_OK
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.junsu.wwwe.R
import app.junsu.wwwe.model.user.SignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = koinViewModel(),
    onNavigateToHomeNav: () -> Unit,
) {
    val context = LocalContext.current
    val sideEffect by viewModel.sideEffectFlow.collectAsState()
    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            SignInSideEffect.SignInSuccess -> onNavigateToHomeNav()
            SignInSideEffect.SignInFailure -> Toast.makeText(
                context,
                context.getString(R.string.sign_in_failure),
                Toast.LENGTH_SHORT,
            ).show()

            SignInSideEffect.UserNotFound -> {} // todo
            null -> {}
        }
    }

    val googleSignInClient by remember { mutableStateOf(getGoogleSignInClient(context)) }

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            if (it.resultCode == RESULT_OK) {
                it.data?.run {
                    val email = GoogleSignIn.getSignedInAccountFromIntent(it.data).result.email!!

                    viewModel.signIn(
                        request = SignInRequest(
                            email = email,
                        ),
                    )
                }
            }
        },
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_app_logo),
            contentDescription = null,
            modifier = Modifier
                .height(256.dp)
                .fillMaxWidth(),
            alignment = Alignment.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 8.dp,
                    end = 16.dp,
                ),
            horizontalArrangement = Arrangement.End,
        ) {
            Button(
                onClick = {
                    googleSignInLauncher.launch(googleSignInClient.signInIntent)
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.sign_in_google),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

private fun getGoogleSignInClient(
    context: Context,
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
