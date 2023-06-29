package app.junsu.wwwe.ui.main.composepost

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.PostRepository
import app.junsu.wwwe.model.post.ComposePostRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ComposePostViewModel(private val postRepository: PostRepository) : ViewModel() {
    val flow = MutableStateFlow(CreatePostState.initial())
    val sideEffectFlow = MutableStateFlow<CreatePostSideEffect?>(null)

    fun updateImage(imageUri: Uri) {
        flow.tryEmit(flow.value.copy(selectedImageUri = imageUri))
    }

    fun composePost(request: ComposePostRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                postRepository.composePost(request)
            }.onSuccess {
                sideEffectFlow.tryEmit(CreatePostSideEffect.PostCreated)
            }.onFailure {
                sideEffectFlow.tryEmit(CreatePostSideEffect.PostCreationFailed)
            }
        }
    }

    fun uploadFile() {
        kotlin.runCatching {
            postRepository.uploadFile(fileUri = flow.value.selectedImageUri!!)
        }.onSuccess {}
    }
}

data class CreatePostState(
    val selectedImageUri: Uri?,
) {
    companion object {
        fun initial() = CreatePostState(
            selectedImageUri = null,
        )
    }
}

sealed interface CreatePostSideEffect {
    object PostCreated : CreatePostSideEffect
    object PostCreationFailed : CreatePostSideEffect
}
