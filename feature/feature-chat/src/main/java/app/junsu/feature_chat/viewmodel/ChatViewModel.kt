package app.junsu.feature_chat.viewmodel

import androidx.lifecycle.ViewModel
import app.junsu.data.datasource.auth.RemoteAuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ChatViewModel(
    private val remoteAuthDataSource: RemoteAuthDataSource,
) : ViewModel() {

}
