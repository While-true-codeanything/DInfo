package com.example.dinfo

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class MemoryAccesser(ct: Context) {
    companion object{
        val File = "Dta"
        val NotList = "Ntf"
    }
    lateinit var accesser: SharedPreferences
    init{
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

    fun setNotifications(data: ArrayList<Object>) { //your NotificationObject
        val editor: SharedPreferences.Editor = accesser.edit()
        val list: MutableSet<String> = HashSet()
        for(i in 0..data.size-1){
            list.add(data[i].toString())
        }
        editor.putStringSet(NotList, list)
        editor.apply()
    }
    fun getNotifications():ArrayList<Object>{ //your NotificationObject
        val editor: SharedPreferences.Editor = accesser.edit()
        val ret  = accesser.getStringSet(NotList, HashSet<String>())
        val list=ArrayList<Object>() //your NotificationObject
        for (str in ret!!) {
            list.add(Object()) // list.add(YourObjectClass.createfromstring())
        }
        return  list
    }
}