package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dinfo.*
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.Adapters.CurrenciesAdapter
import com.example.dinfo.DtClassesAndOth.CurrencydateItem
import com.example.dinfo.DtClassesAndOth.MemoryAccesser
import kotlinx.android.synthetic.main.currencies_page.*

class CurrenciesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currencies_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        var k = MemoryAccesser(activity as MainActivity)
            .getCur()
        colcur.setText(k.size.toString())
        cur_settings.adapter =
            CurrenciesAdapter(this.activity!!, k)
        setcurnum.setOnClickListener {
            var o = cur_settings.adapter as CurrenciesAdapter
            o.CurData.clear()
            for (i in 0..colcur.text.toString().toInt() - 1) {
                o.CurData.add((CurrencydateItem(
                    "CAD",
                    "CAD"
                )))
            }
            o.notifyDataSetChanged()
        }
        Applycur.setOnClickListener {
            val a = activity as MainActivity
            MemoryAccesser(a)
                .Clear(MemoryAccesser.Cur)
            var o = cur_settings.adapter as CurrenciesAdapter
            MemoryAccesser(a).setCur(o.CurData)
            Toast.makeText(context,"Данные сохранены",Toast.LENGTH_LONG).show()
            a.loadFragment(SettingsFragment())
        }
    }
}
