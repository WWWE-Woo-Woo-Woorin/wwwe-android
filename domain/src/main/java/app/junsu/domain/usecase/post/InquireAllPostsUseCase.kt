package app.junsu.domain.usecase.post

import app.junsu.domain.repository.post.PostRepository
import app.junsu.model.post.Post
import javax.inject.Inject

class InquireAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(): List<Post> {
        return postRepository.inquireAllPosts()
    }
}
