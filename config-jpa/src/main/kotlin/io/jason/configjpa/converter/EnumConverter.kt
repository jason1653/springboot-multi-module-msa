package io.jason.configjpa.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


@Converter
class EnumConverter <T : EnumValue>(
    private val enumClass: Class<T>
) : AttributeConverter<T, String> {
    override fun convertToDatabaseColumn(attribute: T): String? {
        return attribute.getValue()
    }

    override fun convertToEntityAttribute(dbData: String?): T? {
        return enumClass.enumConstants?.firstOrNull { it.getValue() == dbData }
    }
}