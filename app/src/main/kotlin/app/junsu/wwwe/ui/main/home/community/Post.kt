package app.junsu.wwwe.ui.main.home.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Post(
    postId: Long,
    postImageUrl: String,
    writer: String,
    writerProfileImageUrl: String,
    content: String,
    totalLikes: Int,
    liked: Boolean,
) {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        GlideImage(
            imageModel = { postImageUrl },
            modifier = Modifier.size(
                width = screenWidthDp,
                height = screenWidthDp,
            ),
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            ),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) {
            GlideImage(
                imageModel = { writerProfileImageUrl },
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        top = 8.dp,
                    )
                    .size(32.dp)
                    .clip(CircleShape),
                imageOptions = ImageOptions(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                ),
            )
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp,
                    )
                    .weight(1f),
            ) {
                Text(
                    text = writer,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
        Divider(thickness = 1.dp)
    }
}

/*
@Composable
fun PostList(
    posts: List<Post>
) {

}
*/
