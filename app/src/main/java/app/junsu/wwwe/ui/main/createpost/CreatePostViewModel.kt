package app.junsu.wwwe.ui.main.createpost

import android.net.Uri
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CreatePostViewModel : ViewModel() {
    val flow = MutableStateFlow(CreatePostState.initial())

    fun updateImage(imageUri: Uri) {
        flow.tryEmit(flow.value.copy(selectedImageUri = imageUri))
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
