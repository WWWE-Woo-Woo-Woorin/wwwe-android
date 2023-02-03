package app.junsu.wwwe

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.junsu.domain.repository.auth.AuthRepository
import app.junsu.domain.usecase.auth.SignUpUseCase
import app.junsu.remote.model.auth.signup.SignUpRequest
import app.junsu.root.MainViewModel
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest @Inject constructor(
    private val authRepository: AuthRepository,
) {

    @Test
    fun signUpTest() {

        val vm = MainViewModel(
            signUpUseCase = SignUpUseCase(
                authRepository = authRepository,
            )
        )

        vm.signUp(
            SignUpRequest(
                "junsu@gmail.com",
                "박박",
            )
        )
    }
}
