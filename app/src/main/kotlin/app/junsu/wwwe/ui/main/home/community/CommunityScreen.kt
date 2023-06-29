package app.junsu.wwwe.ui.main.home.community

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.junsu.wwwe.R
import app.junsu.wwwe.model.post.PostType
import org.koin.androidx.compose.getViewModel

@Immutable
private enum class CommunityTab {
    ALL, MAJOR, CLUB, ;

    val text: String
        @Composable inline get() = stringResource(
            when (this) {
                ALL -> R.string.community_tab_all
                MAJOR -> R.string.community_tab_major
                CLUB -> R.string.community_tab_club
            },
        )
}

@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
    viewModel: CommunityViewModel = getViewModel(),
    onNavigateToCreatePost: () -> Unit,
) {
    val state = viewModel.flow.collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd,
    ) {
        Column {
            TabRow(
                selectedTabIndex = selectedTab,
            ) {
                CommunityTab.values().forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Text(
                                text = tab.text,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary,
                            )
                        },
                    )
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
                        postImageUrl = post.postImageUrl,
                        writer = post.writer,
                        writerProfileImageUrl = post.writerProfileImageUrl,
                        content = post.content,
                        totalLikes = 0,
                        liked = false,
                    )
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "list.lastIndex() + 1",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.error,
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier.padding(
                bottom = 16.dp,
                end = 16.dp,
            ),
            onClick = onNavigateToCreatePost,
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
            )
        }
    }
}
