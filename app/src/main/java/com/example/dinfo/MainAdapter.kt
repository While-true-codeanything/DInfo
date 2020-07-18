package com.example.dinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var position2 = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        position2++
        return when (position2) {
            0 -> {
                GeoHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.weather_item,
                        parent,
                        false
                    )//заменить на геолокационное view
                )
            }
            else -> {
                GeoHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.weather_item, parent, false)//пока не нужно
                )
            }
        }
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            //Вставить данные
        }
    }


    inner class GeoHolder(root: View) :
        RecyclerView.ViewHolder(root) {

    }
}