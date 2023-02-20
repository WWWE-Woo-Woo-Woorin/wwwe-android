package app.junsu.core_datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import app.junsu.model.preference.AppPreferencees
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class AppPreferencesSerializer(
    override val defaultValue: AppPreferencees = AppPreferencees.getDefaultInstance(),
) : Serializer<AppPreferencees> {

    override suspend fun readFrom(
        input: InputStream,
    ): AppPreferencees {
        return try {
            Json.decodeFromString(
                AppPreferencees.serializer(),
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
        t: AppPreferencees,
        output: OutputStream,
    ) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    AppPreferencees.serializer(),
                    t,
                ).encodeToByteArray(),
            )
        }
    }
}
