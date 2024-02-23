package io.jason.configjpa.utils

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


@Converter
class EnumConverter <T : EnumValue>(
    private val enumClass: Class<T>
) : AttributeConverter<T, String> {
    override fun convertToDatabaseColumn(attribute: T): String? {
        return attribute.getValue()
    }

    override fun convertToEntityAttribute(dbData: String?): T {
        TODO("Not yet implemented")
    }
}