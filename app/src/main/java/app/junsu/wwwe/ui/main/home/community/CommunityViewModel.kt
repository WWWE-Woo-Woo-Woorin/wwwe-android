package app.junsu.wwwe.ui.main.home.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.CommunityRepository
import app.junsu.wwwe.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val communityRepository: CommunityRepository,
) : ViewModel() {
    val flow = MutableStateFlow(CommunityState(emptyList()))

    init {
        viewModelScope.launch {
            flow.value = flow.value.copy(posts = communityRepository.testInquirePosts())
        }
    }
}

data class CommunityState(
    val posts: List<Post>,
)
