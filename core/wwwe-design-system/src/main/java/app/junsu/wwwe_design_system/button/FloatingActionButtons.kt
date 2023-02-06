package app.junsu.wwwe_design_system.button

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DefaultFloatingActionButton(
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconTint: Color,
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            painter = painter,
            tint = iconTint,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun DefaultFloatingActionButtonPreview() {
    DefaultFloatingActionButton(
        painter = painterResource(
            id = com.google.android.material.R.drawable.ic_clock_black_24dp,
        ),
        onClick = { /*TODO*/ },
        iconTint = MaterialTheme.colorScheme.surfaceTint,
    )
}
