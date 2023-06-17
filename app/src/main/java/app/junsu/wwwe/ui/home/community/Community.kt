package app.junsu.wwwe.ui.home.community

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun Community(
    viewModel: CommunityViewModel = getViewModel(),
) {
    val state = viewModel.flow.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(state.value.posts) { post ->
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
