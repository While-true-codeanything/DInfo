package com.example.dinfo.Fragments

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.DtClassesAndOth.MemoryAccesser
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
                this.context!!,
                myCallBack,
                Year,
                Month,
                Date
            )
            tpd.datePicker.minDate = Calendar.getInstance().time.time
            tpd.show()
        }
        save.setOnClickListener {
            var ma =
                MemoryAccesser(activity as MainActivity)
            var a = ma.getNotifications()
            var s = Calendar.getInstance()[Calendar.DAY_OF_MONTH].toString() + " " + (Calendar.getInstance()[Calendar.MONTH]+1).toString() + " " + Calendar.getInstance()[Calendar.YEAR].toString()
            val obj=NotificationObject(
                headline.text.toString(),
                bodyline.text.toString(),
                "$Date "+(Month+1).toString()+" $Year",
                s
            )
            if(!(obj.body==""&&obj.head=="")) {
                a.add(obj)
                ma.setNotifications(a)
                Toast.makeText(context, "Данные сохранены", Toast.LENGTH_LONG).show()
                val k = activity as MainActivity
                k.loadFragment(NotificationFragment())
            }else{
                Toast.makeText(context, "Введите описание или заголовок", Toast.LENGTH_LONG).show()
            }
        }
    }

    var myCallBack =
        OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            Year = year
            Month = monthOfYear
            Date = dayOfMonth
        }

}