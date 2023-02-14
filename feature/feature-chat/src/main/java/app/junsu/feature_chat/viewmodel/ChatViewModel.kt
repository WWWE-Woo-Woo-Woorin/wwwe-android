package app.junsu.feature_chat.viewmodel

import androidx.lifecycle.ViewModel
import app.junsu.data.datasource.auth.LocalAuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.getstream.chat.android.client.models.User

@HiltViewModel
internal class ChatViewModel(
    private val localAuthDataSource: LocalAuthDataSource,
) : ViewModel() {

    init {

    }

    internal lateinit var user: User

    private fun fetchUserInformation(): 
}
