package com.example.dinfo.Fragments

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dinfo.MainActivity
import com.example.dinfo.MemoryAccesser
import com.example.dinfo.Notifications.NotificationObject
import com.example.dinfo.R
import kotlinx.android.synthetic.main.notificationadder_page.*
import java.util.*

class NotificationAdderFragment(var Date: Int, var Month: Int, var Year: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notificationadder_page, container, false)
    }

    override fun onStart() {
        super.onStart()

        cd.setOnClickListener {
            var tpd = DatePickerDialog(
                this!!.context!!,
                myCallBack,
                Year,
                Month,
                Date
            );
            tpd.getDatePicker().minDate = Calendar.getInstance().getTime().getTime()
            tpd.show();
        }
        save.setOnClickListener {
            var ma = MemoryAccesser(activity as MainActivity)
            var a = ma.getNotifications()
            var s =
                Calendar.getInstance()[Calendar.DAY_OF_MONTH].toString() + " " + Calendar.getInstance()[Calendar.MONTH].toString() + " " + Calendar.getInstance()[Calendar.YEAR].toString()
            a.add(
                NotificationObject(
                    headline.text.toString(),
                    bodyline.text.toString(),
                    "$Date $Month $Year",
                    s
                )
            )
            ma.setNotifications(a)

        }
    }

    var myCallBack =
        OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            Year = year
            Month = monthOfYear
            Date = dayOfMonth
            Toast.makeText(
                context,
                "$Year $Month $Date ",
                Toast.LENGTH_LONG
            ).show()
        }

}