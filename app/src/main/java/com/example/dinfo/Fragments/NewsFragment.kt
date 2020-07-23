package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dinfo.*
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.news_page.*
import kotlinx.android.synthetic.main.weather_page.*
import java.text.SimpleDateFormat
import java.util.*

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        var a=MemoryAccesser(this!!.context!!)
        ne.setText(a.getSettings(MemoryAccesser.NewsNum))
        setcurnews.setOnClickListener {
            a.setSettings(ne.text.toString(),MemoryAccesser.NewsNum)
        }
        news_settings.adapter=NewsAdapter(activity as MainActivity)
    }

}
