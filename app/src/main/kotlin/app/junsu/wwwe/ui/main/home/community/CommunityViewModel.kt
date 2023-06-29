package app.junsu.wwwe.ui.main.home.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.PostRepository
import app.junsu.wwwe.model.post.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val postRepository: PostRepository,
) : ViewModel() {
    val flow = MutableStateFlow(CommunityState.initial())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                postRepository.inquirePosts()
            }.onSuccess {
                flow.value = flow.value.copy(posts = postRepository.inquirePosts())
            }
        }
    }
}

data class CommunityState(
    val posts: List<Post>,
) {
    companion object {
        fun initial() = CommunityState(
            posts = emptyList(),
        )
    }
}
