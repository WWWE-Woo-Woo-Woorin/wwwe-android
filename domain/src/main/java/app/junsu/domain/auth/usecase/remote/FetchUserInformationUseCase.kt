package app.junsu.domain.auth.usecase.remote

import app.junsu.domain.auth.repository.remote.RemoteAuthRepository
import app.junsu.model.common.User
import javax.inject.Inject

class FetchUserInformationUseCase @Inject constructor(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(): User {
        return remoteAuthRepository.fetchUserInformation()
    }
}
