package app.junsu.wwwe.ui.home.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Community() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState(),
            ),
    ) {
        repeat(3) {
            Post(
                postId = 123,
                imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA0MjhfMzEg%2FMDAxNjgyNjQ4OTY0NTc5._LfcSxCiUwPlljgw6-XP2JD3PkuYkuXcqQs_WQz1Mmkg.sulvdNT6G3BZOz8fEcu_rIbBAwcwgMpWihqagmk6iJ4g.JPEG.aboard13389%2FKakaoTalk_20230420_120739846_03_%25282%2529.jpg&type=sc960_832",
                profileUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA0MjhfMzEg%2FMDAxNjgyNjQ4OTY0NTc5._LfcSxCiUwPlljgw6-XP2JD3PkuYkuXcqQs_WQz1Mmkg.sulvdNT6G3BZOz8fEcu_rIbBAwcwgMpWihqagmk6iJ4g.JPEG.aboard13389%2FKakaoTalk_20230420_120739846_03_%25282%2529.jpg&type=sc960_832",
                writer = "Junsu",
                content = "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello",
                totalLikes = 123,
                liked = true,
            )
        }
    }
}
