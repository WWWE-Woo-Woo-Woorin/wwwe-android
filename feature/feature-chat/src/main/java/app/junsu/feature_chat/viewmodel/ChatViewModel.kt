package app.junsu.feature_chat.viewmodel

import androidx.lifecycle.ViewModel
import app.junsu.data.datasource.auth.RemoteAuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val remoteAuthDataSource: RemoteAuthDataSource,
) : ViewModel() {

}
