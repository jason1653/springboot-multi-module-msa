package io.jason.configsecurity

import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class JasyptConfigTest {
    private fun createStringEncryptor(password: String): StringEncryptor {
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig().apply {
            this.password = password
            algorithm = "PBEWithMD5AndDES"
            keyObtentionIterations = 1000
            poolSize = 1
            providerName = "SunJCE"
        }
        encryptor.setConfig(config)
        return encryptor
    }

    @Test
    fun testEncryptDecrypt() {
        val password = "secret"
        val stringEncryptor = createStringEncryptor(password)

        val originalText = "Hello, World!"

        // 암호화 수행
        val encryptedText = stringEncryptor.encrypt(originalText)

        // 복호화 수행
        val decryptedText = stringEncryptor.decrypt(encryptedText)

        // 원본 텍스트와 복호화된 텍스트가 일치하는지 확인
        assertEquals(originalText, decryptedText)

        println(encryptedText)
        println(decryptedText)
    }
}