package app.junsu.core_datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import app.junsu.model.preference.UserPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class UserPreferencesSerializer(
    override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance(),
) : Serializer<UserPreferences> {

    override suspend fun readFrom(
        input: InputStream,
    ): UserPreferences {
        return try {
            Json.decodeFromString(
                UserPreferences.serializer(),
                input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            throw CorruptionException(
                "Unable to read UserPreferences",
                e,
            )
        }
    }

    override suspend fun writeTo(
        t: UserPreferences,
        output: OutputStream,
    ) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    UserPreferences.serializer(),
                    t,
                ).encodeToByteArray(),
            )
        }
    }
}
