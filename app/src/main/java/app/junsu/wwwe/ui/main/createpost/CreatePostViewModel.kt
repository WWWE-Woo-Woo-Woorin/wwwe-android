package app.junsu.wwwe.ui.main.createpost

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.PostRepository
import app.junsu.wwwe.model.CreatePostRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CreatePostViewModel(private val postRepository: PostRepository) : ViewModel() {
    val flow = MutableStateFlow(CreatePostState.initial())
    val sideEffectFlow = MutableStateFlow<CreatePostSideEffect?>(null)

    fun updateImage(imageUri: Uri) {
        flow.tryEmit(flow.value.copy(selectedImageUri = imageUri))
    }

    fun createPost(request: CreatePostRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                postRepository.createPost(request)
            }.onSuccess {
                sideEffectFlow.tryEmit(CreatePostSideEffect.PostCreated)
            }.onFailure {
                sideEffectFlow.tryEmit(CreatePostSideEffect.PostCreationFailed)
            }
        }
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
