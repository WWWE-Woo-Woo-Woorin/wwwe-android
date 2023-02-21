package app.junsu.model.preference

@kotlinx.serialization.Serializable
data class AppPreferences(
    val isSignedIn: Boolean = false,
) {
    companion object {
        fun getDefaultInstance(): AppPreferences {
            return AppPreferences(
                isSignedIn = false,
            )
        }
    }
}
