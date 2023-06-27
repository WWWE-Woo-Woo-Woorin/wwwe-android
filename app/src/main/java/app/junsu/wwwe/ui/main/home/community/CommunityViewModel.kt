package app.junsu.wwwe.ui.main.home.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.CommunityRepository
import app.junsu.wwwe.model.post.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val communityRepository: CommunityRepository,
) : ViewModel() {
    val flow = MutableStateFlow(CommunityState(emptyList()))

    init {
        viewModelScope.launch {
            flow.value = flow.value.copy(posts = communityRepository.inquirePosts())
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
