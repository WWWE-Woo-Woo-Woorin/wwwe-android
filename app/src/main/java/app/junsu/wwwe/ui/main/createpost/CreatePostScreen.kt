package app.junsu.wwwe.ui.main.createpost

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun CreatePostScreen() {
    val (text, onTextChange) = remember { mutableStateOf("") }
    Column {
        OutlinedTextField(value = text, onValueChange = onTextChange)
    }
}
