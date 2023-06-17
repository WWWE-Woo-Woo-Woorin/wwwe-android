package app.junsu.wwwe.ui.home.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.wwwe.data.CommunityRepository
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val communityRepository: CommunityRepository,
) : ViewModel() {
    init {
        viewModelScope.launch {
            communityRepository.testInquirePosts()
        }
    }
}
