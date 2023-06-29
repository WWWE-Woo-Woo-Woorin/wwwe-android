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
    val flow = MutableStateFlow(ComposePostState.initial())
    val sideEffectFlow = MutableStateFlow<ComposePostSideEffect?>(null)

    fun updateImage(imageUri: Uri) {
        flow.tryEmit(flow.value.copy(selectedImageUri = imageUri))
    }

    fun composePost(request: ComposePostRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                postRepository.composePost(request)
            }.onSuccess {
                sideEffectFlow.tryEmit(ComposePostSideEffect.PostCreated)
            }.onFailure {
                sideEffectFlow.tryEmit(ComposePostSideEffect.PostCreationFailed)
            }
        }
    }

    fun uploadFile() {
        kotlin.runCatching {
            postRepository.uploadFile(fileUri = flow.value.selectedImageUri!!)
        }.onSuccess {}
    }
}

data class ComposePostState(
    val selectedImageUri: Uri?,
) {
    companion object {
        fun initial() = ComposePostState(
            selectedImageUri = null,
        )
    }
}

sealed interface ComposePostSideEffect {
    object PostCreated : ComposePostSideEffect
    object PostCreationFailed : ComposePostSideEffect
}
