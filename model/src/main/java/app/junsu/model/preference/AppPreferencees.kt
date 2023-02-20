package app.junsu.model.preference

@kotlinx.serialization.Serializable
data class AppPreferencees(
    val isSignedIn: Boolean = false,
) {
    companion object {
        fun getDefaultInstance(): AppPreferencees {
            return AppPreferencees(
                isSignedIn = false,
            )
        }
    }
}
