package com.example.dinfo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var loc: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(
                this@MainActivity, "Smth went wrong",
                Toast.LENGTH_LONG
            ).show()
            // Здесь будет обработка ошибок
            // Надо добавить проверку на интернет
            return
        } else loc.requestSingleUpdate(LocationManager.GPS_PROVIDER, listener, null)
    }

    private val listener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            Toast.makeText(
                this@MainActivity,
                "Широта:" + location?.latitude.toString() + "\n Долгота:" + location?.longitude.toString(),
                Toast.LENGTH_LONG
            ).show()
            val gt=DataLoader()
            Toast.makeText(
                this@MainActivity,
                gt.GetLocation(location?.latitude!!, location?.longitude!!,this@MainActivity),
                Toast.LENGTH_LONG
            ).show()

            //Здесь будет получение данных
            //Необходимо добавить диалог на разрешение получения местоположения

        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}