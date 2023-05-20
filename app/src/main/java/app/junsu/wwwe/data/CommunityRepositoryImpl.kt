package app.junsu.wwwe.data

import app.junsu.wwwe.model.Post

class CommunityRepositoryImpl(
) : CommunityRepository {

    fun testInquirePosts(
        postId: Long,
    ): List<Post> {
        return listOf(
            Post(
                1,
                "",
                "",
                "",
            ),
        )
    }

    override fun inquirePosts(): List<Post> {
        TODO("Not yet implemented")
    }
}
