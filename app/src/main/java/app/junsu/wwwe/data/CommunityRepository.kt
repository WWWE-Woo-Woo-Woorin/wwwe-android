package app.junsu.wwwe.data

import app.junsu.wwwe.model.Post

interface CommunityRepository {
    fun inquirePosts(): List<Post>
}
