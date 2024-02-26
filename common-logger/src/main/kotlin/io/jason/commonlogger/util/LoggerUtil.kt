package io.jason.commonlogger.util

inline fun <reified T> T.LoggerUtil() = org.slf4j.LoggerFactory.getLogger(T::class.java)