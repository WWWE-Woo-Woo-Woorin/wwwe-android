package app.junsu.wwwe.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class Post(
    @SerialName("post_id") val id: Long,
    @SerialName("writer") val writer: String,
    @SerialName("content") val content: String,
    @SerialName("post_image_url") val postImageUrl: String,
    //@SerialName("created_at") val createdAt: LocalDateTime,
)
