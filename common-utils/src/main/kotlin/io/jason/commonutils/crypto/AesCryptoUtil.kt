package io.jason.commonutils.crypto

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

const val AES_INSTANCE = "AES/ECB/PKCS5Padding"

@Component
class AesCryptoUtil(
    @Value("\${aes.key}")
    private val aesKey: String,
) {
    init {
        checkAESKey()
    }

    /**
     * 옵션 KEY 값이 8자리인지 확인
     */
    private fun checkAESKey() {
        require(aesKey.length == 8) { "AES Key 값은 8자리여야 합니다." }
    }

    /**
     * AES Key 생성
     */
    private fun createAESKey(key: String): SecretKeySpec {
        require(key.length == 8) { "AES Key 값은 8자리여야 합니다." }

        var secretKey = aesKey + key

        if (secretKey.length > 16) {
            secretKey = secretKey.substring(0, 16)
        } else {
            secretKey = secretKey.padEnd(16, '0')
        }

        return SecretKeySpec(secretKey.toByteArray(), "AES")
    }

    /**
     * AES 암호화
     */
    fun aesEncrypt(
        str: String,
        key: String,
    ): String? {
        try {
            val secretKey = createAESKey(key)
            val cipher = Cipher.getInstance(AES_INSTANCE)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)

            val encrypted = cipher.doFinal(str.toByteArray(Charsets.UTF_8))
            val encryptedString = Base64.getEncoder().encodeToString(encrypted)

            return encryptedString
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    fun aesDecrypt(
        str: String,
        key: String,
    ): String? {
        try {
            val secretKey = createAESKey(key)
            val cipher = Cipher.getInstance(AES_INSTANCE)
            cipher.init(Cipher.DECRYPT_MODE, secretKey)

            val encrypted = Base64.getDecoder().decode(str)
            val decrypted = cipher.doFinal(encrypted)
            return decrypted.toString(Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

}