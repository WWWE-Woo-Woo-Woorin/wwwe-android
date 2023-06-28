package app.junsu.wwwe

import androidx.lifecycle.ViewModel
import app.junsu.wwwe.data.UserRepository
import kotlinx.coroutines.runBlocking

class MainViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    fun regenerateToken(): Boolean {
        return runBlocking {
            val result = kotlin.runCatching {
                userRepository.regenerateToken()
            }.onFailure { it.printStackTrace() }
            return@runBlocking result.isSuccess
        }
    }
}
