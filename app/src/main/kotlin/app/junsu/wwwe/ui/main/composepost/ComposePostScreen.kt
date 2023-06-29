package app.junsu.wwwe.ui.main.composepost

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.junsu.wwwe.R
import app.junsu.wwwe.model.post.ComposePostRequest
import app.junsu.wwwe.model.post.PostType
import app.junsu.wwwe.model.post.PostType.*
import app.junsu.wwwe.ui.component.AppBar
import com.skydoves.landscapist.InternalLandscapistApi
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel

@InternalLandscapistApi
@Composable
fun ComposePostScreen(
    modifier: Modifier = Modifier,
    viewModel: ComposePostViewModel = koinViewModel(),
    onNavigateUp: () -> Unit,
) {
    val state by viewModel.flow.collectAsState()
    val sideEffect by viewModel.sideEffectFlow.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            ComposePostSideEffect.PostCreated -> onNavigateUp()
            ComposePostSideEffect.PostCreationFailed -> Toast.makeText(
                context,
                context.getString(R.string.compose_post_failed),
                Toast.LENGTH_SHORT,
            ).show()

            null -> {}
        }
    }

    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val pickPhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { if (it != null) viewModel.updateImage(it) },
    )

    val (postContentText, onTextChange) = remember { mutableStateOf("") }
    val (selectedPostType, onSelectedTypeChange) = remember { mutableStateOf(DEFAULT) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppBar(
            title = stringResource(R.string.compose_post),
            onNavigateUp = onNavigateUp,
        )
        Spacer(modifier = Modifier.height(48.dp))
        GlideImage(
            modifier = Modifier
                .size(screenWidthDp)
                .clickable {
                    pickPhotoLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                },
            imageModel = { state.selectedImageUri ?: R.drawable.img_gallery },
        )
        PostTypeChips(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            chips = PostType.values().toList(),
            selectedPostType = selectedPostType,
            onSelectPostType = onSelectedTypeChange,
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),
            value = postContentText,
            onValueChange = onTextChange,
            maxLines = 4,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 8.dp,
                    end = 16.dp,
                ),
            horizontalArrangement = Arrangement.End,
        ) {
            Button(
                onClick = {
                    viewModel.composePost(
                        request = ComposePostRequest(
                            // todo
                            postImageUrl = "https://static.toss.im/homepage-static/newtoss/newtoss-og.jpg",
                            content = postContentText,
                            postType = selectedPostType.name,
                        ),
                    )
                },
                enabled = postContentText.isNotBlank(),
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.compose),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

private val PostType.text: String
    @Composable inline get() = when (this) {
        DEFAULT -> stringResource(R.string.community_tab_all)
        MAJOR -> stringResource(R.string.community_tab_major)
        CLUB -> stringResource(R.string.community_tab_club)
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PostTypeChips(
    modifier: Modifier = Modifier,
    chips: List<PostType>,
    selectedPostType: PostType,
    onSelectPostType: (PostType) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        chips.forEach { currentPostType ->
            ElevatedFilterChip(
                selected = selectedPostType == currentPostType,
                onClick = { onSelectPostType(currentPostType) },
                label = {
                    Text(
                        text = currentPostType.text,
                        style = MaterialTheme.typography.labelLarge,
                    )
                },
            )
        }
    }
}
