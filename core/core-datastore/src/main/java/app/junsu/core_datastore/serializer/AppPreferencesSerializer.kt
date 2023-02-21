package app.junsu.core_datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import app.junsu.model.preference.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class AppPreferencesSerializer(
    override val defaultValue: AppPreferences = AppPreferences.getDefaultInstance(),
) : Serializer<AppPreferences> {

    override suspend fun readFrom(
        input: InputStream,
    ): AppPreferences {
        return try {
            Json.decodeFromString(
                AppPreferences.serializer(),
                input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            throw CorruptionException(
                "Unable to read AppPreferences",
                e,
            )
        }
    }

    override suspend fun writeTo(
        t: AppPreferences,
        output: OutputStream,
    ) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    AppPreferences.serializer(),
                    t,
                ).encodeToByteArray(),
            )
        }
    }
}
