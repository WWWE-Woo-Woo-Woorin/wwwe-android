package app.junsu.wwwe.ui.home.community

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
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
import app.junsu.wwwe.model.PostType
import org.koin.androidx.compose.getViewModel

@Immutable
private enum class CommunityTab(
    val value: String,
) {
    ALL("ALL"), MAJOR("MAJOR"), CLUB("CLUB"), ;

    val text: String
        @Composable get() = stringResource(
            when (this) {
                ALL -> R.string.community_tab_all
                MAJOR -> R.string.community_tab_major
                CLUB -> R.string.community_tab_club
            }
        )
}

@Composable
fun Community(
    viewModel: CommunityViewModel = getViewModel(),
    onNavigateToCreatePost: () -> Unit,
) {
    val state = viewModel.flow.collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
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
        FloatingActionButton(
            modifier = Modifier.padding(
                bottom = 16.dp,
                end = 16.dp,
            ),
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Filled.AddComment,
                contentDescription = null,
            )
        }
    }
}
