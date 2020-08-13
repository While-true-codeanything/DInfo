package com.example.dinfo.Activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.dinfo.R
import kotlinx.android.synthetic.main.activity_connection_check.*

class ConnectionCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection_check)

        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected && (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED)
        ) startActivity(Intent(this, MainActivity::class.java))
        else {
            Toast.makeText(
                this,
                "Нет подключения к сети или нет разрешения на определение местоположения. Попробуйте еще раз",
                Toast.LENGTH_SHORT
            ).show()
            button2.visibility = VISIBLE
            tosettings.visibility = VISIBLE
        }
        tosettings.setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
        button2.setOnClickListener { this.recreate() }
    }
}