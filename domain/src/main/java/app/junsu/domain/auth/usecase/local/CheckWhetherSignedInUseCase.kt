package app.junsu.domain.auth.usecase.local

import app.junsu.domain.auth.repository.LocalAuthRepository
import javax.inject.Inject

/**
 * Signed in status when true returned
 */
class CheckWhetherSignedInUseCase @Inject constructor(
    private val localAuthRepository: LocalAuthRepository,
) {
    suspend operator fun invoke(): Boolean {
        return localAuthRepository.isSignedIn()
    }
}
