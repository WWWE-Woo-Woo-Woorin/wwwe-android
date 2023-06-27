package app.junsu.wwwe.data

import app.junsu.wwwe.data.remote.client.BASE_URL
import app.junsu.wwwe.model.post.CreatePostRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class PostRepository(
    private val httpClient: HttpClient,
) {
    suspend fun createPost(request: CreatePostRequest) {
        httpClient.post("$BASE_URL/v1/posts") {
            setBody(request)
        }
    }
}
