package app.junsu.data.post.repository

import app.junsu.data.post.datasource.PostDataSource
import app.junsu.domain.post.model.CreatePostRequest
import app.junsu.domain.post.model.UpdatePostRequest
import app.junsu.domain.post.repository.PostRepository
import app.junsu.model.post.Post
import app.junsu.model.post.PostType
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource,
) : PostRepository {

    override suspend fun createPost(request: CreatePostRequest): Post {
        return postDataSource.createPost(
            request = request,
        )
    }

    override suspend fun inquireAllPosts(): List<Post?> {
        return postDataSource.inquireAllPosts()
    }

    override suspend fun inquirePosts(postType: PostType): List<Post?> {
        return postDataSource.inquirePosts(
            postType = postType,
        )
    }

    override suspend fun inquirePost(postId: Long): Post {
        return postDataSource.inquirePost(
            postId = postId,
        )
    }

    override suspend fun updatePost(postId: Long, request: UpdatePostRequest): Post {
        return postDataSource.updatePost(
            postId = postId,
            request = request,
        )
    }

    override suspend fun deletePost(postId: Long) {
        postDataSource.deletePost(
            postId = postId,
        )
    }
}
