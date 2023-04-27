package app.junsu.wwwe.ui.home.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Post(
    postId: Long,
    imageUrl: String,
    profileUrl: String,
    writer: String,
    content: String,
    totalLikes: Int,
    liked: Boolean,
) {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        GlideImage(
            imageModel = { imageUrl },
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
        ) {
            GlideImage(
                imageModel = { profileUrl },
                modifier = Modifier.size(24.dp),
                imageOptions = ImageOptions(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                ),
            )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = writer,
                    style = MaterialTheme.typography.headlineMedium,
                )
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Composable
fun PostList(
    posts: List<Post>
) {

}
