package app.junsu.wwwe_design_system.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(
            text = text,
        )
    }
}

@Preview
@Composable
private fun DefaultButtonPreview() {
    DefaultButton(
        text = "다음으로",
        onClick = {

        }
    )
}
