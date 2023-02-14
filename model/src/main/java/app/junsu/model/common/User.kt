package app.junsu.model.common

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val username: String,
    val profileUrl: String?,
)
