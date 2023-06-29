package app.junsu.wwwe.data

import app.junsu.wwwe.data.remote.BASE_URL
import app.junsu.wwwe.model.post.CreatePostRequest
import app.junsu.wwwe.model.post.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostRepository(
    private val httpClient: HttpClient,
    private val tokenFacade: TokenFacade,
) {
    suspend fun createPost(request: CreatePostRequest) {
        httpClient.post("$BASE_URL/v1/posts") {
            contentType(ContentType.Application.Json)
            bearerAuth(tokenFacade.findAccessTokenOrRegenerate())
            setBody(request)
        }
    }

    suspend fun inquirePosts(): List<Post> {
        return httpClient.get("$BASE_URL/v1/posts") {
            bearerAuth(tokenFacade.findAccessTokenOrRegenerate())
        }.body()
    }
}
