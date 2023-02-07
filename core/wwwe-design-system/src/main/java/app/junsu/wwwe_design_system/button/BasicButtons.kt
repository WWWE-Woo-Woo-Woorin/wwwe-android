package app.junsu.wwwe_design_system.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {

        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.padding(
                    end = 8.dp,
                ),
            )
        }

        Text(
            text = text,
        )
    }
}

@Preview
@Composable
private fun DefaultButtonPreview() {
    Column {

        DefaultButton(
            text = "Login with google",
            onClick = {},
            icon = painterResource(
                id = com.google.android.material.R.drawable.material_ic_edit_black_24dp,
            ),
        )
    }
}
