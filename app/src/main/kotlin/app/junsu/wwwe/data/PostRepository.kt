package app.junsu.wwwe.data

import android.net.Uri
import app.junsu.wwwe.data.remote.BASE_URL
import app.junsu.wwwe.model.post.ComposePostRequest
import app.junsu.wwwe.model.post.Post
import app.junsu.wwwe.model.post.PostType
import com.google.firebase.storage.FirebaseStorage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostRepository(
    private val httpClient: HttpClient,
    private val tokenFacade: TokenFacade,
) {
    suspend fun inquirePosts(): List<Post> {
        return httpClient.get("$BASE_URL/v1/posts") {
            bearerAuth(tokenFacade.findAccessTokenOrRegenerate())
        }.body()
    }

    fun composePost(
        postImageUri: Uri,
        content: String,
        postType: PostType,
    ) {
        val dbRef = FirebaseStorage.getInstance().reference
        val fileRef = dbRef.child(
            "${System.currentTimeMillis()}.${postImageUri.toString().split(".")[1]}",
        )
        fileRef.putFile(postImageUri)
        fileRef.downloadUrl.addOnSuccessListener {
            CoroutineScope(Dispatchers.IO).launch {
                val request = ComposePostRequest(
                    postImageUrl = it.toString(),
                    content = content,
                    postType = postType.name,
                )
                httpClient.post("$BASE_URL/v1/posts") {
                    contentType(ContentType.Application.Json)
                    bearerAuth(tokenFacade.findAccessTokenOrRegenerate())
                    setBody(request)
                }
            }
        }
    }
}
