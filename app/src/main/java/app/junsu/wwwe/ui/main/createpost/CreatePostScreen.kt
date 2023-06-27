package app.junsu.wwwe.ui.main.createpost

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
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.junsu.wwwe.R
import app.junsu.wwwe.ui.component.AppBar
import com.skydoves.landscapist.InternalLandscapistApi
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel

@InternalLandscapistApi
@Composable
fun CreatePostScreen(
    modifier: Modifier = Modifier,
    viewModel: CreatePostViewModel = koinViewModel(),
    onNavigateUp: () -> Unit,
) {
    val state by viewModel.flow.collectAsState()
    val (text, onTextChange) = remember { mutableStateOf("") }
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val pickPhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { if (it != null) viewModel.updateImage(it) },
    )
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppBar(
            title = stringResource(R.string.compose_new_post),
            onNavigateUp = onNavigateUp,
        )
        Spacer(modifier = Modifier.height(32.dp))
        GlideImage(
            modifier = Modifier
                .size(screenWidthDp)
                .clickable {
                    pickPhotoLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                },
            imageModel = { state.selectedImageUri ?: R.drawable.img_add_photo },
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),
            value = text,
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
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Filled.AddComment,
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
