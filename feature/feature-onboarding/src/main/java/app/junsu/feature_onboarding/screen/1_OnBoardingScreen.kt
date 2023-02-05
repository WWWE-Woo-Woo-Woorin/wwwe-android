package app.junsu.feature_onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.junsu.common_compose.util.VerticalSpacer
import app.junsu.feature_onboarding.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

private val previewPagerImages = listOf(
    R.drawable.img_onboarding_preview_1,
    R.drawable.img_onboarding_preview_2,
    R.drawable.img_onboarding_preview_3,
    R.drawable.img_onboarding_preview_4,
)

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun OnBoardingScreen(
    navController: NavController,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp

    val previewPagerState = rememberPagerState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(
            modifier = Modifier.weight(1f),
        )

        HorizontalPager(
            count = previewPagerImages.size,
            state = previewPagerState,
        ) { pageIndex ->
            Image(
                painter = painterResource(
                    previewPagerImages[pageIndex],
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(
                    screenWidth.dp,
                ),
            )
        }

        VerticalSpacer(
            height = 32.dp,
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LinearProgressIndicator(
                progress = 0.5f,
            )

            VerticalSpacer(
                height = 32.dp,
            )

            Text(
                text = "Title",
                style = MaterialTheme.typography.subtitle1,
            )

            VerticalSpacer(
                height = 16.dp,
            )

            Text(
                text = "Description",
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {

    val navController = rememberNavController()

    MaterialTheme {
        Surface {
            OnBoardingScreen(
                navController = navController,
            )
        }
    }
}
