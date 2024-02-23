package io.jason.configjpa.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Converter(autoApply = true)
class LocalDataTimeConverter : AttributeConverter<LocalDateTime, String> {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    override fun convertToDatabaseColumn(localDataTime: LocalDateTime?): String? {
        return localDataTime?.format(formatter)

    }

    override fun convertToEntityAttribute(dbData: String?): LocalDateTime? {
        return LocalDateTime.parse(dbData, formatter)
    }

}