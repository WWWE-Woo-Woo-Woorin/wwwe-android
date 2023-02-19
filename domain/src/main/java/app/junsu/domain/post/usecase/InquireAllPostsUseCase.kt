package app.junsu.domain.post.usecase

import app.junsu.domain.post.repository.PostRepository
import app.junsu.model.post.Post
import javax.inject.Inject

class InquireAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(): List<Post> {
        return postRepository.inquireAllPosts()
    }
}
