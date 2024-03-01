package io.jason.commonutils.mapper

import org.springframework.stereotype.Component


@Component
abstract class MapperConverter <E, M> {
    abstract fun toModel(entity: E): M
    abstract fun toEntity(model: M): E
}