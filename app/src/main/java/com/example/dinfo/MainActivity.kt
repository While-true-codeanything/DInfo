package com.example.dinfo

import android.Manifest
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.dinfo.Fragments.AppSettingsFragment
import com.example.dinfo.Fragments.MainPageFragment
import com.example.dinfo.Fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    fun loadFragment(fragment: Fragment) {
        pd.dismiss()
        val ft =
            supportFragmentManager.beginTransaction()
        ft.replace(R.id.Place, fragment)
        ft.commit()
    }
    lateinit var pd: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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
        } else {
            pd = ProgressDialog(this)
            pd.setMessage("Загрузка данныx!\nПожалуйста подождите")
            pd.show()
            loc.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, listener, null)
        }
        Navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    title="DInfo"
                    loadFragment(MainPageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_viewsettings -> {
                    title="Info Settings"
                    loadFragment(SettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_settings -> {
                    title="App Settings"
                    loadFragment(AppSettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    private val listener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            Toast.makeText(
                this@MainActivity,
                "Широта:" + location?.latitude.toString() + "\n Долгота:" + location?.longitude.toString(),
                Toast.LENGTH_LONG
            ).show()
            val gt = DataLoader()
            gt.GetLocation(location?.latitude!!, location?.longitude!!, this@MainActivity)
            gt.GetWeather(location?.latitude!!, location?.longitude!!, this@MainActivity)
            gt.GetNews("ru", this@MainActivity)
            gt.GetCurrenccies("EUR", this@MainActivity)
            //Здесь будет получение данных
            //Необходимо добавить диалог на разрешение получения местоположения

        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}