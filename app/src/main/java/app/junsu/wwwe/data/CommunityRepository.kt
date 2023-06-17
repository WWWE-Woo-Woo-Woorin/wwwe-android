package app.junsu.wwwe.data

import app.junsu.wwwe.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CommunityRepository(
    private val httpClient: HttpClient,
) {
    suspend fun testInquirePosts(): List<Post> {
        return httpClient.get("$BASE_URL/v1/posts").body()
    }
}

const val BASE_URL = "http://172.30.1.85"
