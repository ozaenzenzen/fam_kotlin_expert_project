package com.famandexpertapp1.core.data.source.local.userpref

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

object EncryptionUtils {

    private const val ALGORITHM = "AES"
    private const val TRANSFORMATION = "AES"

    // Generate a new AES key (store this key securely if you are using it across sessions)
    fun generateKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance(ALGORITHM)
        keyGenerator.init(256) // AES-256 encryption
        return keyGenerator.generateKey()
    }

    // Encrypt the string using the provided key
    fun encrypt(key: SecretKey, data: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedData = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
        return Base64.encodeToString(encryptedData, Base64.DEFAULT)
    }

    // Decrypt the string using the provided key
    fun decrypt(key: SecretKey, encryptedData: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, key)
        val decodedData = Base64.decode(encryptedData, Base64.DEFAULT)
        val decryptedData = cipher.doFinal(decodedData)
        return String(decryptedData, Charsets.UTF_8)
    }
}