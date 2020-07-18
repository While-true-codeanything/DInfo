package com.example.dinfo

import Json4Kotlin_Base
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DataLoader {
    fun GetLocation(lat:Double, long:Double,context:Context): String{
        var res:String="Ошибка определения местоположения"
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://geocode-maps.yandex.ru") //unused
            .build()

        val service: Interfaces.GeoService =
            retrofit.create(Interfaces.GeoService::class.java)
        val pd = ProgressDialog.show(
            context, "", "Loading", true,
            false
        )//Пока устаревшее, но рабочее решение, потом заменим
        service.getLocation(lat, long).enqueue(object : Callback<Json4Kotlin_Base?> {
            override fun onResponse(
                call: Call<Json4Kotlin_Base?>?,
                response: Response<Json4Kotlin_Base?>
            ) {
                res= response.body()!!.response.geoObjectCollection.featureMember.get(0).geoObject.description
            }

            override fun onFailure(call: Call<Json4Kotlin_Base?>?, t: Throwable?) {
                Toast.makeText(
                    context, "Ошибка, проверьте подключение к интернету или доступность сервиса!",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        pd.dismiss()
        return res // ошибок быть не должно, только если в работе сервиса
    }
}