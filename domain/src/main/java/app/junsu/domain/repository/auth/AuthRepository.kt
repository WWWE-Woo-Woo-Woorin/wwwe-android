package app.junsu.domain.repository.auth

interface AuthRepository {

    suspend fun signIn(
        email: String,
    )

    suspend fun fetchToken(
        accessToken: String,
    )

    suspend fun saveToken(
        accessToken: String,
    )
}
