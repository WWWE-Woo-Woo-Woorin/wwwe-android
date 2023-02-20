package app.junsu.remote.post.model

import com.google.gson.annotations.SerializedName

data class CreatePostRequest(
    @SerializedName("postImageUrl") val postImageUrl: String,
    @SerializedName("content") val content: String,
    @SerializedName("postType") val postType: String,
)
