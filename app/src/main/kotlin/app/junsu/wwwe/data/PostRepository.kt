package app.junsu.wwwe.data

import android.net.Uri
import app.junsu.wwwe.data.remote.BASE_URL
import app.junsu.wwwe.model.post.ComposePostRequest
import app.junsu.wwwe.model.post.Post
import com.google.firebase.storage.FirebaseStorage
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
    suspend fun composePost(request: ComposePostRequest) {
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

    fun uploadFile(fileUri: Uri): String {
        val dbRef = FirebaseStorage.getInstance().reference
        val fileRef =
            dbRef.child("${System.currentTimeMillis()}.${fileUri.toString().split(".")[1]}")
        fileRef.putFile(fileUri).addOnSuccessListener {}

        return "stub"
    }
}
