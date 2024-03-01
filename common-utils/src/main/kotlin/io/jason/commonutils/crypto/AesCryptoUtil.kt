package io.jason.commonutils.crypto

interface AesCryptoUtil {
    fun aesEncrypt(str: String, key: String): String?
    fun aesEncrypt(str: String): String?

    fun createKey(length: Int): String

    fun aesDecrypt(str: String, key: String): String?
}