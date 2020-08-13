package com.example.dinfo.Activities

import android.Manifest
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.dinfo.*
import com.example.dinfo.DtClassesAndOth.AllAppData
import com.example.dinfo.DtClassesAndOth.CurrencydateItem
import com.example.dinfo.DtClassesAndOth.DataLoader
import com.example.dinfo.DtClassesAndOth.MemoryAccesser
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
        if (MemoryAccesser(this).CheckIfFirstStart()) {
            val a = ArrayList<CurrencydateItem>()
            a.add((CurrencydateItem(
                "EUR",
                "RUB"
            )))
            a.add((CurrencydateItem(
                "USD",
                "RUB"
            )))
            val v = MemoryAccesser(this)
            v.setCur(a)
            v.setSettings("5",
                MemoryAccesser.NewsNum
            )
        }
        var loc: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        } else {
            pd = ProgressDialog(this)
            pd.setMessage("Загрузка данныx!\nПожалуйста подождите")
            pd.setCancelable(false)
            pd.show()
            if (MemoryAccesser(this)
                    .getSettings(MemoryAccesser.GeoProvider) == "Network") {
                loc.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, listener, null)
            } else loc.requestSingleUpdate(LocationManager.GPS_PROVIDER, listener, null)
        }
        Navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    title = "DInfo"
                    loadFragment(MainPageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_viewsettings -> {
                    title = "Info Settings"
                    loadFragment(SettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_settings -> {
                    title = "App Settings"
                    loadFragment(AppSettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    override fun onBackPressed() {
        if(Navigation.selectedItemId==R.id.navigation_home) super.onBackPressed()
        else {
            Navigation.selectedItemId = R.id.navigation_home
            this.loadFragment(MainPageFragment())
        }
    }

    private val listener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            AllAppData.latitude = location?.latitude.toString()
            AllAppData.longitude = location?.longitude.toString()
            val gt = DataLoader()
            gt.GetLocation(location?.latitude!!, location.longitude, this@MainActivity)
            gt.GetWeather(location.latitude, location.longitude, this@MainActivity)
            gt.GetNews("ru", this@MainActivity)
            gt.GetCurrenccies("EUR", this@MainActivity)
            gt.GetHoliday(this@MainActivity)
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

}