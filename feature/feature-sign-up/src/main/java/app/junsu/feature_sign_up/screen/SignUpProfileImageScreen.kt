package app.junsu.feature_sign_up.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import app.junsu.core_route.route.WWWERoutes
import app.junsu.feature_sign_up.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SignUpProfileImageScreen(
    navController: NavHostController,
) {

    val onNextButtonClick = {
        navController.navigate(WWWERoutes.Auth.SignUp.ProfileImage.route)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        GlideImage(
            imageModel = painterResource(
                id = R.drawable.img_sign_up_default_profile,
            ),
            circularReveal = CircularReveal(
                duration = 250,
            ),
        )
    }
}