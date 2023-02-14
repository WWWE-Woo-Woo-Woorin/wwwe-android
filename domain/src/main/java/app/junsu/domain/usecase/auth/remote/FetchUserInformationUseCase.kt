package app.junsu.domain.usecase.auth.remote

import app.junsu.domain.repository.auth.remote.RemoteAuthRepository
import app.junsu.model.common.User
import javax.inject.Inject

class FetchUserInformationUseCase @Inject constructor(
    private val remoteAuthRepository: RemoteAuthRepository,
) {
    suspend operator fun invoke(): User {
        return remoteAuthRepository.fetchUserInformation()
    }
}
