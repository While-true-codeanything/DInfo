package com.example.dinfo

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_connection_check.*

class ConnectionCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection_check)

        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected) startActivity(Intent(this, MainActivity::class.java))
        else {
            Toast.makeText(
                this, "Нет подключения к сети. Попробуйте еще раз.",
                Toast.LENGTH_SHORT
            ).show()
            button2.visibility = VISIBLE
        }
        button2.setOnClickListener { this.recreate() }
    }
}