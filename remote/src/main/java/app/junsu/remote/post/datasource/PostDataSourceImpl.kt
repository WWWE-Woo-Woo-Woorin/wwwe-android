package app.junsu.remote.post.datasource

import app.junsu.data.post.datasource.PostDataSource
import app.junsu.domain.post.model.CreatePostRequest
import app.junsu.domain.post.model.UpdatePostRequest
import app.junsu.model.post.Post
import app.junsu.model.post.PostType
import app.junsu.remote._util.HTTPHandler
import app.junsu.remote.post.api.PostAPI
import app.junsu.remote.post.extension.toData
import app.junsu.remote.post.model.toPost
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postApi: PostAPI,
) : PostDataSource {

    override suspend fun createPost(request: CreatePostRequest): Post {
        return HTTPHandler {
            postApi.createPost(
                request = request.toData(),
            )
        }.toPost()
    }

    override suspend fun inquireAllPosts(): List<Post?> {
        return HTTPHandler {
            postApi.inquireAllPosts()
        }.toPost()
    }

    override suspend fun inquirePosts(postType: PostType): List<Post?> {
        return HTTPHandler {
            postApi.inquirePosts(
                postType = postType,
            )
        }.toPost()
    }

    override suspend fun inquirePost(postId: Long): Post {
        return HTTPHandler {
            postApi.inquirePost(
                postId = postId,
            )
        }.toPost()
    }

    override suspend fun updatePost(
        postId: Long,
        request: UpdatePostRequest,
    ): Post {
        return HTTPHandler {
            postApi.updatePost(
                postId = postId,
                request = request.toData(),
            )
        }.toPost()
    }

    override suspend fun deletePost(postId: Long) {
        HTTPHandler {
            postApi.deletePost(
                postId = postId,
            )
        }
    }
}
