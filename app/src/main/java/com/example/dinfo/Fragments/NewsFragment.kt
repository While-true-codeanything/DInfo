package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dinfo.AllAppData
import com.example.dinfo.R
import com.example.dinfo.WeatherAdapter
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.weather_page.*
import java.text.SimpleDateFormat
import java.util.*

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_page, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

}
