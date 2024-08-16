package com.famandexpertapp1.core.data.source.local.userpref

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.File
import java.security.SecureRandom
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data_prefs")

//private val Context.encrypted: DataStore<Preferences> by preferencesDataStore(name = "user_data_prefs")

@Singleton
class UserDataPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token_key")
    }

    // Save token
    suspend fun setToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }

    // Get token
    fun getToken(): Flow<String?> {
        val data =
            context.dataStore.data
                .map { preferences ->
                    preferences[TOKEN_KEY]
                }
        return data
    }


    // Clear token
    suspend fun clearToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(TOKEN_KEY)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun encryptData(userData: String): String {
        // Generate a random initialization vector (IV)
        val iv = ByteArray(16)
        SecureRandom().nextBytes(iv)

        // Replace with your actual encryption key
        val key = "your_secret_key".toByteArray()

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))


        val encryptedData = cipher.doFinal(userData.toByteArray())
//        val encryptedData = cipher.doFinal(userData)
        return Base64.getEncoder().encodeToString(iv + encryptedData)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun decryptData(encryptedData: String): String? {
        val decodedData = Base64.getDecoder().decode(encryptedData)
        val iv = decodedData.copyOfRange(0, 16)
        val encryptedContent = decodedData.copyOfRange(16, decodedData.size)

        // Replace with your actual encryption key
        val key = "your_secret_key".toByteArray()

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))


        val decryptedData = cipher.doFinal(encryptedContent)
//        return Json.decodeFromString(decryptedData.decodeToString())
        return String(decryptedData)
    }
}