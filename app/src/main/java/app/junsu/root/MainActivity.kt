package app.junsu.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column {
                    NextButton(text = "Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoScreen() {
    NextButton(text = "HI")
}

@Composable
fun NextButton(
    text: String,
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(48.dp),
    ) {
        Text(text = text)
    }
}
