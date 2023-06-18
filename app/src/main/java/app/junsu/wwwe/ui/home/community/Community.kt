package app.junsu.wwwe.ui.home.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import app.junsu.wwwe.model.PostType
import org.koin.androidx.compose.getViewModel

@Stable
val communityTabs = listOf<String>("All", "Major", "Club")

@Composable
fun Community(
    viewModel: CommunityViewModel = getViewModel(),
) {
    val state = viewModel.flow.collectAsState()
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
        ) {
            communityTabs.forEachIndexed { index, tab ->
                Tab(selected = selectedTab == index, onClick = { setSelectedTab(index) }, text = {
                    Text(
                        text = tab,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                })
            }
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            val posts = state.value.posts

            items(
                when (selectedTab) {
                    0 -> posts
                    1 -> posts.filter { it.postType == PostType.MAJOR }
                    2 -> posts.filter { it.postType == PostType.CLUB }
                    else -> throw IllegalStateException()
                },
            ) { post ->
                Post(
                    postId = post.id,
                    imageUrl = post.postImageUrl,
                    profileUrl = "",
                    writer = post.writer,
                    content = post.content,
                    totalLikes = 0,
                    liked = false,
                )
            }
        }
    }
}
