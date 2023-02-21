package app.junsu.feature_sign_up.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.junsu.core_route.route.WWWERoutes
import app.junsu.wwwe_design_system.button.DefaultButton

@Composable
fun SignUpUsernameScreen(
    navController: NavHostController,
) {

    val onNextButtonClick = {
        navController.navigate(WWWERoutes.Auth.SignUp.ProfileImage.route)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        DefaultButton(
            modifier = Modifier
                .align(
                    Alignment.BottomEnd,
                )
                .padding(
                    end = 16.dp,
                    bottom = 16.dp,
                ),
            text = "다음", // todo
            onClick = onNextButtonClick,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun SignUpScreenPreview() {

    val navController = rememberNavController()

    SignUpUsernameScreen(navController = navController)
}
