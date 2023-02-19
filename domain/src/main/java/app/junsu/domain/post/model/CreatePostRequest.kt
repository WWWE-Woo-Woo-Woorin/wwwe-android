package app.junsu.domain.post.model

data class CreatePostRequest(
    val postImageUrl: String,
    val content: String,
    val postType: String,
)
