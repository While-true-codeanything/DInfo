package com.example.dinfo

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.dinfo.Notifications.NotificationObject

class MemoryAccesser(ct: Context) {
    companion object {
        val File = "Dta"
        val NotList = "Ntf"
        val GeoProvider = "GeoGetter"
        val Cur = "Cur"
        val NewsNum = "NumOfNews"
    }

    lateinit var accesser: SharedPreferences

    init {
        try {
            val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            accesser = ct.getSharedPreferences(
                File,
                Context.MODE_PRIVATE
            )
            accesser = EncryptedSharedPreferences.create(
                File,
                masterKeyAlias,
                ct,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun setNotifications(data: ArrayList<NotificationObject>) {
        val editor: SharedPreferences.Editor = accesser.edit()
        val list: MutableSet<String> = HashSet()
        for (i in 0..data.size - 1) {
            list.add(data[i].toString())
        }
        editor.putStringSet(NotList, list)
        editor.apply()
    }

    fun getNotifications(): ArrayList<NotificationObject> {
        val editor: SharedPreferences.Editor = accesser.edit()
        val ret = accesser.getStringSet(NotList, HashSet<String>())
        val list = ArrayList<NotificationObject>() //your NotificationObject
        for (str in ret!!) {
            list.add(NotificationObject.fromString(str))
        }
        return list
    }

    fun setCur(data: ArrayList<CurrencydateItem>) { //your NotificationObject
        val editor: SharedPreferences.Editor = accesser.edit()
        val list: MutableSet<String> = HashSet()
        for (i in 0..data.size - 1) {
            Log.i("Строка создания: ", data[i].toString())
            list.add(data[i].toString())
        }
        editor.putStringSet(Cur, list)
        editor.apply()
    }

    fun Clear(key: String) {
        val editor: SharedPreferences.Editor = accesser.edit()
        editor.remove(key)
    }

    fun getCur(): ArrayList<CurrencydateItem> { //your NotificationObject
        val editor: SharedPreferences.Editor = accesser.edit()
        val ret = accesser.getStringSet(Cur, HashSet<String>())
        val list = ArrayList<CurrencydateItem>() //your NotificationObject
        for (str in ret!!) {
            Log.i("Строка: ", CurrencydateItem.fromString(str).toString())
            list.add(CurrencydateItem.fromString(str)) // list.add(YourObjectClass.createfromstring())
        }
        return list
    }

    fun setSettings(state: String, param: String) {
        val editor: SharedPreferences.Editor = accesser.edit()
        editor.putString(param, state)
        editor.apply()
    }

    fun getSettings(param: String): String {
        if (accesser.contains(param)) {
            return accesser.getString(param, "").toString()
        } else return "error"
    }

    fun CheckIfFirstStart(): Boolean {
        if (!accesser.contains(GeoProvider)) {
            setSettings("Network", GeoProvider)
            return true
        }
        return false
    }
}