package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.DtClassesAndOth.MemoryAccesser
import com.example.dinfo.Adapters.NewsAdapter
import com.example.dinfo.R
import kotlinx.android.synthetic.main.news_page.*

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        var a = MemoryAccesser(this.context!!)
        ne.setText(a.getSettings(MemoryAccesser.NewsNum))
        setcurnews.setOnClickListener {
            a.setSettings(ne.text.toString(), MemoryAccesser.NewsNum)
            Toast.makeText(context,"Данные сохранены", Toast.LENGTH_LONG).show()
            val k =activity as MainActivity
            k.loadFragment(SettingsFragment())
        }
        news_settings.adapter =
            NewsAdapter(activity as MainActivity)
    }

}
