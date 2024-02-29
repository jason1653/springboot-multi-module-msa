package io.jason.commonutils.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RestController
@RequestMapping
annotation class WebAdapter(
    @get:AliasFor(annotation = RequestMapping::class)
    val value: String = "",

    @get:AliasFor(annotation = RequestMapping::class, attribute = "path")
    val path: String = ""
)
