package app.junsu.domain.post.repository

import app.junsu.domain.post.model.CreatePostRequest
import app.junsu.domain.post.model.UpdatePostRequest
import app.junsu.model.post.Post
import app.junsu.model.post.PostType

interface PostRepository {

    suspend fun createPost(
        request: CreatePostRequest,
    ): Post

    suspend fun inquireAllPosts(): List<Post>

    suspend fun inquirePosts(
        postType: PostType,
    ): List<Post>

    suspend fun inquirePost(
        postId: Long,
    ): Post

    suspend fun updatePost(
        postId: Long,
        request: UpdatePostRequest,
    ): Post

    suspend fun deletePost(
        postId: Long,
    )
}
