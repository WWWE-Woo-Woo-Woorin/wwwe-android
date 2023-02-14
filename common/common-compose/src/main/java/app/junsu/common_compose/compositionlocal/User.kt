package app.junsu.common_compose.compositionlocal

import android.annotation.SuppressLint
import androidx.compose.runtime.staticCompositionLocalOf
import app.junsu.model.common.User

@SuppressLint("CompositionLocalNaming")
var User = staticCompositionLocalOf<User> {
    User(
        email = "Loading email",
        username = "Loading username",
        profileUrl = "https://lh3.googleusercontent.com/cZfAIL9fBywTCJ2Y9KeCBZs858-7kXUyBnk-1BduPVtOle2rwHm12fPXQDkfqGdfp8EB5bevrAUhiTpr=w544-h544-l90-rj",
    )
}
