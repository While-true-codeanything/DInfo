package com.example.dinfo.Fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dinfo.DtClassesAndOth.AllAppData
import com.example.dinfo.DtClassesAndOth.MemoryAccesser
import com.example.dinfo.R
import kotlinx.android.synthetic.main.settings.*

class AppSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings, container, false)
    }

    override fun onStart() {
        super.onStart()
        val r = MemoryAccesser(this.context!!)
            .getSettings(MemoryAccesser.GeoProvider)
        if (r == "Gps") Gps_network.isChecked = false
        Gps_network.setOnCheckedChangeListener { buttonView, isChecked ->
            if (!isChecked) {
                Toast.makeText(
                    context,
                    "Данные будут немного точнее, но их получение будет занимать больше времени",
                    Toast.LENGTH_LONG
                ).show()
                MemoryAccesser(this.context!!)
                    .setSettings("Gps", MemoryAccesser.GeoProvider)
            } else {
                Toast.makeText(
                    context,
                    "Данные будут немного менее точные, но их получение будет занимать меньше времени",
                    Toast.LENGTH_LONG
                ).show()
                MemoryAccesser(this.context!!)
                    .setSettings("Network", MemoryAccesser.GeoProvider)
            }
        }
        coord.text="Широта: " + String.format("%.3f", AllAppData.latitude.toDouble()) + "\n Долгота:" +String.format("%.3f", AllAppData.longitude.toDouble())
        val content = SpannableString(delete.text)
        content.setSpan(UnderlineSpan(), 0, delete.text.length, 0)
        delete.text=content
        delete.setOnClickListener {
            MemoryAccesser(this.activity!!).DeleteAll()
            activity!!.finish()
        }
    }

}
