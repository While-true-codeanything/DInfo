package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.R
import com.example.dinfo.Adapters.SettingsAdapter
import com.example.dinfo.DtClassesAndOth.SettingsItem
import kotlinx.android.synthetic.main.settings_page.*

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        val list = ArrayList<SettingsItem>()
        list.add(
            SettingsItem(
                "Погода",
                WeatherFragment()
            )
        )
        list.add(
            SettingsItem(
                "Новости",
                NewsFragment()
            )
        )
        list.add(
            SettingsItem(
                "Курсы валют",
                CurrenciesFragment()
            )
        )
        list.add(
            SettingsItem(
                "Напоминания",
                NotificationFragment()
            )
        )
        this.activity!!.con.adapter = SettingsAdapter(
            list,
            activity as MainActivity
        )
    }

}
