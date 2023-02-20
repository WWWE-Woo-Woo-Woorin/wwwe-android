package app.junsu.wwwe

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.junsu.domain.auth.repository.LocalAuthRepository
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
    private val localAuthRepository: LocalAuthRepository,
) {

    @Test
    fun signUpTest() {
    }
}
