package app.junsu.remote.post.extension

import app.junsu.domain.post.model.CreatePostRequest as DomainCreatePostRequest
import app.junsu.remote.post.model.CreatePostRequest as DataCreatePostRequest

internal fun DomainCreatePostRequest.toData(): DataCreatePostRequest {
    return DataCreatePostRequest(
        postImageUrl = this.postImageUrl,
        content = this.content,
        postType = this.postType,
    )
}
