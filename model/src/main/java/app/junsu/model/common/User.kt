package app.junsu.model.common

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val username: String,
    val profileUrl: String? = "https://lh3.googleusercontent.com/uAxlSvSvAYe6rA-h3vItHWMuGqER3GJa9YMoZsf3Obmr_T47HggwKaQf8GsaufArJq0u9Cj8w8KxsVY=w544-h544-l90-rj",
)
