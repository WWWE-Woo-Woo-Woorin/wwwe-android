package app.junsu.remote.post.api

import app.junsu.model.post.PostType
import app.junsu.remote._common.URL
import app.junsu.remote.post.model.CreatePostRequest
import app.junsu.remote.post.model.PostResponse
import app.junsu.remote.post.model.UpdatePostRequest
import retrofit2.http.*

interface PostAPI {

    @POST(URL.Post.CREATE_POST)
    suspend fun createPost(
        request: CreatePostRequest,
    ): PostResponse

    @GET(URL.Post.INQUIRE_ALL_POSTS)
    suspend fun inquireAllPosts(): List<PostResponse>

    @GET(URL.Post.INQUIRE_POSTS)
    suspend fun inquirePosts(
        @Query("type") postType: PostType,
    ): List<PostResponse>

    @GET(URL.Post.INQUIRE_POST)
    suspend fun inquirePost(
        @Path("post-id") postId: Long,
    ): PostResponse

    @PATCH(URL.Post.UPDATE_POST)
    suspend fun updatePost(
        @Path("post-id") postId: Long,
        @Body request: UpdatePostRequest,
    ): PostResponse

    @DELETE(URL.Post.DELETE_POST)
    suspend fun deletePost(
        @Path("post-id") postId: Long,
    )
}
