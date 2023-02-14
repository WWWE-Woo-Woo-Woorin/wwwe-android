package app.junsu.common_compose.compositionlocal

import android.annotation.SuppressLint
import androidx.compose.runtime.staticCompositionLocalOf
import app.junsu.model.common.User

@SuppressLint("CompositionLocalNaming")
val User = staticCompositionLocalOf<User> {
    error(
        "Loading ;)",
    )
}
