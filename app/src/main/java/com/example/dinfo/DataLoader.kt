package com.example.dinfo


import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.example.example.MainGeoResponse
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
            .baseUrl("https://geocode-maps.yandex.ru")
            .build()

        val service: Interfaces.GeoService =
            retrofit.create(Interfaces.GeoService::class.java)
        val pd = ProgressDialog.show(
            context, "", "Loading", true,
            false
        )//Пока устаревшее, но рабочее решение, потом заменим
        service.getLocation("$long,$lat").enqueue(object : Callback<MainGeoResponse> {
            override fun onResponse(
                call: Call<MainGeoResponse>,
                response: Response<MainGeoResponse>
            ) {
                Toast.makeText(
                    context, response.body()?.response!!.GeoObjectCollection.featureMember[0].GeoObject.description,
                    Toast.LENGTH_LONG
                ).show()
                /*res= response.body()!!.response.geoObjectCollection.featureMember.get(0).geoObject.description*/
            }

            override fun onFailure(call: Call<MainGeoResponse?>, t: Throwable?) {
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