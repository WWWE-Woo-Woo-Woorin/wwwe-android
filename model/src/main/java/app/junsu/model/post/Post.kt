package app.junsu.model.post

import java.time.LocalDateTime

data class Post(
    val postId: Long,
    val writer: String,
    val content: String,
    val postImageUrl: String,
    val createdAt: LocalDateTime,
)
