package app.junsu.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.junsu.domain.param.auth.SignUpParam
import app.junsu.domain.usecase.auth.SignUpUseCase
import app.junsu.remote.model.auth.signup.SignUpRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
) : ViewModel() {

    // todo make private
    internal fun signUp(
        signUpRequest: SignUpRequest,
    ) {
        viewModelScope.launch {
            signUpUseCase(
                SignUpParam(
                    email = signUpRequest.email,
                    username = signUpRequest.username,
                    profileUrl = signUpRequest.profileUrl,
                ),
            ).onSuccess {

            }
        }
    }
}
