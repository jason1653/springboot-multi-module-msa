package io.jason.commonutils.mapper

import org.modelmapper.ModelMapper
import java.util.stream.Collectors

class ModelConverter {
    companion object {
        private val modelMapper = ModelMapper()
        fun <T> toMonoModel(user: Any?, outClass: Class<T>?): T? {
            return modelMapper.map(user, outClass)
        }


        fun <T> toModel(user: Any?, outClass: Class<T>?): T? {
            return modelMapper.map(user, outClass)
        }

        fun <T> toCollection(users: List<*>, outClass: Class<T>?): MutableList<T> {
            return users.stream().map { user ->
                user?.let {
                    toModel(it, outClass)
                }
            }.collect(Collectors.toList())
        }
    }
}