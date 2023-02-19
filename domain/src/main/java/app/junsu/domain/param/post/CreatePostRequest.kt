package app.junsu.domain.param.post

data class CreatePostRequest(
    val postImageUrl: String,
    val content: String,
    val postType: String,
)
