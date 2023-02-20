package app.junsu.remote.post.model

import com.google.gson.annotations.SerializedName

data class UpdatePostRequest(
    @SerializedName("content") val content: String,
)
