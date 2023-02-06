package app.junsu.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.junsu.remote.model.auth.signup.SignUpRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen(
                    onTestButtonClick = {
                        viewModel.signUp(
                            signUpRequest = SignUpRequest(
                                "Leesin@gmail.com",
                                "이용진짱",
                                "www.google.com",
                            ),
                        )
                    },
                )
            }
        }
    }
}

@Composable
private fun MainScreen(
    onTestButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        NextButton(
            text = "테스트",
            onClick = onTestButtonClick,
        )
    }
}

@Composable
internal fun NextButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.height(40.dp),
    ) {
        Text(text = text)
    }
}

/*
internal sealed class NavigationRoutes(
    internal val route: String,
) {
    object OnBoarding : NavCont
}
*/
