package app.junsu.remote.post.model

import app.junsu.model.post.Post
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class PostResponse(
    @SerializedName("postId") val postId: Long,
    @SerializedName("writer") val writer: String,
    @SerializedName("content") val content: String,
    @SerializedName("postImageUrl") val postImageUrl: String,
    @SerializedName("createdAt") val createdAt: LocalDateTime,
)

internal fun PostResponse.toPost(): Post {
    return Post(
        postId = this.postId,
        writer = this.writer,
        content = this.content,
        postImageUrl = this.postImageUrl,
        createdAt = this.createdAt,
    )
}
