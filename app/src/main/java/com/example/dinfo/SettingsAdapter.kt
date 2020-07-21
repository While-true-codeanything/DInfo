package com.example.dinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.infosettings_item.view.*

class SettingsAdapter(var Fragmentlist: ArrayList<SettingsItem>,var MA:MainActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =   SettingsHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.infosettings_item,
            parent,
            false
        )
    )

    override fun getItemCount(): Int= Fragmentlist.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as SettingsHolder
        holder.date.text=Fragmentlist[position].Name
        holder.date.setOnClickListener { MA.loadFragment(Fragmentlist[position].fragment) }
    }

    inner class SettingsHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val date = root.setinfo
    }
}