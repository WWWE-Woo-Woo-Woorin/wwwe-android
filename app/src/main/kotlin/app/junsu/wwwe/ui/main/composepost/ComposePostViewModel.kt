package app.junsu.wwwe.ui.main.composepost

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.PostRepository
import app.junsu.wwwe.model.post.PostType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ComposePostViewModel(private val postRepository: PostRepository) : ViewModel() {
    val flow = MutableStateFlow(ComposePostState.initial())
    val sideEffectFlow = MutableStateFlow<ComposePostSideEffect?>(null)

    private val imageSelected: Boolean
        inline get() = flow.value.selectedImageUri != null

    private val composeButtonEnabled: Boolean
        inline get() = imageSelected && flow.value.text.isNotBlank()

    fun updateImage(imageUri: Uri) {
        flow.tryEmit(
            flow.value.copy(
                selectedImageUri = imageUri,
                composeButtonEnabled = composeButtonEnabled,
            ),
        )
    }

    fun updateText(value: String) {
        flow.tryEmit(
            flow.value.copy(
                text = value,
                composeButtonEnabled = composeButtonEnabled,
            ),
        )
    }

    fun uploadImageAndComposePost() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                postRepository.composePost(
                    postImageUri = flow.value.selectedImageUri!!,
                    content = flow.value.text,
                    postType = flow.value.postType,
                )
            }.onSuccess {
                sideEffectFlow.tryEmit(ComposePostSideEffect.PostCreated)
            }.onFailure {
                sideEffectFlow.tryEmit(ComposePostSideEffect.PostCreationFailed)
            }
        }
    }

    fun updatePostType(value: PostType) {
        flow.tryEmit(flow.value.copy(postType = value))
    }
}

data class ComposePostState(
    val selectedImageUri: Uri?,
    val text: String,
    val postType: PostType,
    val composeButtonEnabled: Boolean,
) {
    companion object {
        fun initial() = ComposePostState(
            selectedImageUri = null,
            text = "",
            postType = PostType.DEFAULT,
            composeButtonEnabled = false,
        )
    }
}

sealed interface ComposePostSideEffect {
    object PostCreated : ComposePostSideEffect
    object PostCreationFailed : ComposePostSideEffect
}
