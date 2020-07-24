package com.example.dinfo.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dinfo.DtClassesAndOth.CurrencydateItem
import com.example.dinfo.R
import kotlinx.android.synthetic.main.currencychoser_item.view.*

class CurrenciesAdapter(val m: Activity, var CurData: ArrayList<CurrencydateItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        SettingsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.currencychoser_item,
                parent,
                false
            )
        )

    override fun getItemCount() = CurData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as SettingsHolder
        var a = holder.from.adapter as ArrayAdapter<String>
        a.getPosition(CurData.get(position).frm)
        holder.from.setSelection(a.getPosition(CurData.get(position).frm))
        a = holder.to.adapter as ArrayAdapter<String>
        holder.to.setSelection(a.getPosition(CurData.get(position).to))
        holder.from.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position2: Int,
                id: Long
            ) {
                CurData.get(position).frm = holder.from.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        holder.to.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position2: Int,
                id: Long
            ) {
                CurData.get(position).to = holder.to.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

    }

    inner class SettingsHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val from = root.from
        val to = root.to
    }
}