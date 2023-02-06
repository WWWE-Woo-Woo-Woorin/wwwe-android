package app.junsu.feature_onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import app.junsu.wwwe_design_system.button.DefaultButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

private val previewPagerImages = listOf(
    R.drawable.img_onboarding_preview_1,
    R.drawable.img_onboarding_preview_2,
    R.drawable.img_onboarding_preview_3,
    R.drawable.img_onboarding_preview_4,
)

private val previewTitleAndDescriptions = listOf(
    Pair("First Title", "First Description"),
    Pair("Second Title", "Second Description"),
    Pair("Third Title", "Third Description"),
    Pair("Fourth Title", "Fourth Description"),
)

private val indicatorIncreaseValue: Float = 1 / previewPagerImages.size.toFloat()

private val indicatorDefaultValue: Float
    get() = indicatorIncreaseValue

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun OnBoardingScreen(
    navController: NavController,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp

    val previewPagerState = rememberPagerState(
        initialPage = 0,
    )

    val scope = rememberCoroutineScope()

    var previewIndicatorState by remember {
        mutableStateOf(indicatorDefaultValue)
    }

    var titleAndDescriptionsState by remember {
        mutableStateOf(previewTitleAndDescriptions[0])
    }

    val onNextButtonClick = {

        if (previewIndicatorState < 1) {

            previewIndicatorState += indicatorIncreaseValue

            titleAndDescriptionsState =
                previewTitleAndDescriptions[previewPagerState.currentPage + 1]
        } else {
            // TODO else
        }

        scope.launch {
            previewPagerState.scrollToPage(previewPagerState.currentPage + 1)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {

        HorizontalPager(
            modifier = Modifier.align(Alignment.Center),
            count = previewPagerImages.size,
            state = previewPagerState,
            userScrollEnabled = false,
        ) { page ->

            Image(
                painter = painterResource(
                    previewPagerImages[page],
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
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 16.dp,
                )
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LinearProgressIndicator(
                progress = previewIndicatorState,
            )

            VerticalSpacer(
                height = 32.dp,
            )

            Text(
                text = titleAndDescriptionsState.first,
                style = MaterialTheme.typography.subtitle1,
            )

            VerticalSpacer(
                height = 16.dp,
            )

            Text(
                text = titleAndDescriptionsState.second,
                style = MaterialTheme.typography.body1,
            )

            DefaultButton(
                modifier = Modifier.align(Alignment.End),
                text = "다음", // todo
                onClick = {
                    onNextButtonClick()
                },
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
