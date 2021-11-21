package ru.weber.remindme.data.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object AppSettingSerializer : Serializer<AppSetting> {

    override val defaultValue: AppSetting = AppSetting.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): AppSetting {
        try {
            return createAppSetting(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto", exception)
        }
    }

    override suspend fun writeTo(t: AppSetting, output: OutputStream) = writeToAppSetting(t, output)

    private fun createAppSetting(input: InputStream) = AppSetting.parseFrom(input)

    private fun writeToAppSetting(t: AppSetting, output: OutputStream) {
        t.writeTo(output)
    }
}

