package app.junsu.feature_onboarding.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
    Pair(
        first = R.string.on_boarding_1_title_first,
        second = R.string.on_boarding_1_desc_first,
    ),
    Pair(
        R.string.on_boarding_1_title_second,
        R.string.on_boarding_1_desc_second,
    ),
    Pair(
        R.string.on_boarding_1_title_third,
        R.string.on_boarding_1_desc_third,
    ),
    Pair(
        R.string.on_boarding_1_title_fourth,
        R.string.on_boarding_1_desc_fourth,
    ),
)

private val indicatorIncreaseValue: Float = 1 / previewPagerImages.size.toFloat()

private val indicatorDefaultValue: Float
    get() = indicatorIncreaseValue

@OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
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

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {

        val (
            pager,
            indicator,
            textFields,
            nextButton,
        ) = createRefs()

        HorizontalPager(
            modifier = Modifier.constrainAs(pager) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
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

            LinearProgressIndicator(
                progress = previewIndicatorState,
                modifier = Modifier
                    .constrainAs(indicator) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth(),
            )
        }

        Column(
            modifier = Modifier
                .constrainAs(textFields) {
                    top.linkTo(pager.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            VerticalSpacer(
                height = 32.dp,
            )

            Text(
                text = stringResource(
                    id = titleAndDescriptionsState.first,
                ),
                style = MaterialTheme.typography.subtitle1,
            )

            VerticalSpacer(
                height = 16.dp,
            )

            Text(
                text = stringResource(
                    id = titleAndDescriptionsState.second,
                ),
                style = MaterialTheme.typography.body1,
            )
        }
        DefaultButton(
            modifier = Modifier
                .constrainAs(nextButton) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(
                    end = 16.dp,
                    bottom = 16.dp,
                ),
            text = "다음", // todo
            onClick = {
                onNextButtonClick()
            },
        )
    }
}

@Preview
@Composable
private fun OnBoardingScreenPreview() {

    val navController = rememberNavController()

    MaterialTheme {
        Surface {
            OnBoardingScreen(
                navController = navController,
            )
        }
    }
}
