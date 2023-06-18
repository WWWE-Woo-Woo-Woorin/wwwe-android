package app.junsu.wwwe.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    @SerialName("post_id") val id: Long,
    @SerialName("post_type") val postType: PostType,
    @SerialName("writer") val writer: String,
    @SerialName("content") val content: String,
    @SerialName("post_image_url") val postImageUrl: String,
    @SerialName("created_at") val createdAt: String,
)

@Serializable
enum class PostType {
    @SerialName("DEFAULT")
    DEFAULT,

    @SerialName("MAJOR")
    MAJOR,

    @SerialName("CLUB")
    CLUB, ;
}
