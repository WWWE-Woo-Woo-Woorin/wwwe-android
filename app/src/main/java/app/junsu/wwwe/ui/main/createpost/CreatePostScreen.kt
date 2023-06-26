package app.junsu.wwwe.ui.main.createpost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun CreatePostScreen(
    modifier: Modifier = Modifier,
) {
    val (text, onTextChange) = remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
        )
    }
}
