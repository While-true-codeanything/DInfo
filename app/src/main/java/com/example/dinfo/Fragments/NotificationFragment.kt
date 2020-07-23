package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dinfo.MainActivity
import com.example.dinfo.MemoryAccesser
import com.example.dinfo.NotificationAdapter
import com.example.dinfo.Notifications.NotificationObject
import com.example.dinfo.R
import kotlinx.android.synthetic.main.notification_page.*
import java.util.*
import kotlin.collections.ArrayList

class NotificationFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notification_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        clearnot.setOnClickListener {
            MemoryAccesser(activity as MainActivity).setNotifications(ArrayList())
        }
        addnot.setOnClickListener {
            val a=activity as MainActivity
            a.loadFragment(NotificationAdderFragment(
                Calendar.getInstance()[Calendar.DAY_OF_MONTH],
                Calendar.getInstance()[Calendar.MONTH],
                Calendar.getInstance()[Calendar.YEAR]))
        }
        rec.adapter=NotificationAdapter(activity as MainActivity)
    }

}