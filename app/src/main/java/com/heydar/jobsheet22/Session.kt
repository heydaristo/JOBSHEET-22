package com.heydar.jobsheet22

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

class Session(context: Context) {
    private val USERNAME_KEY = "key_username"
    private val NAMALENGKAP_KEY = "key_nama_lengkap"

    private var preferences: SharedPreferences = context.getSharedPreferences("Login App", Context.MODE_PRIVATE)

    fun getUser(): String? {
        return preferences.getString(NAMALENGKAP_KEY, null)
    }

    fun setSession(username: String?, nama_lengkap: String?) {
        preferences.edit().putString(USERNAME_KEY, username)
            .apply()

        preferences.edit().putString(NAMALENGKAP_KEY, nama_lengkap)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        val username = preferences.getString(USERNAME_KEY, null)
        return username != null
    }

    fun validate(username: String, password: String?): Boolean {
        val namalengkap = "HEYDARISTO ZHAHIR RAZAQ"
        if (username == "Admin" && password == "Admin123") {
            setSession(username, namalengkap)
            return true
        } else if (username == "Radiva" && password == "Radiva123") {
            setSession(username, namalengkap)
            return true
        } else if (username == "2996" && password == "2996") {
            setSession(username, namalengkap)
            return true
        } else if (username == "Heydar" && password == "Heydar123") {
            setSession(username, namalengkap)
            return true
        }
        return false
    }
    fun logout() {
        preferences.edit().remove(USERNAME_KEY)
            .remove(NAMALENGKAP_KEY)
            .apply()
    }
}