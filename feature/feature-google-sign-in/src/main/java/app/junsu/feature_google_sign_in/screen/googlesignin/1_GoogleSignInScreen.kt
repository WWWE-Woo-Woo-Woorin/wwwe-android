package app.junsu.feature_google_sign_in.googlesignin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.junsu.feature_sign_in_google.R
import app.junsu.wwwe_design_system.button.DefaultButton

@Composable
fun GoogleSignInScreen(
    navController: NavController,
) {

    val onStartWithGoogleAccountButtonClick = {

    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.wwwe_app_logo,
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(256.dp),
        )

        DefaultButton(
            text = "Google 계정으로 시작하기",
            onClick = onStartWithGoogleAccountButtonClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 16.dp,
                    bottom = 16.dp,
                ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GoogleSignInScreenPreview() {

    val navController = rememberNavController()

    MaterialTheme {

        GoogleSignInScreen(
            navController = navController,
        )
    }
}
