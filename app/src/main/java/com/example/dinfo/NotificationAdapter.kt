package com.example.dinfo

import android.app.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinfo.Notifications.NotificationObject
import kotlinx.android.synthetic.main.infosettings_item.view.*
import kotlinx.android.synthetic.main.notificationrem_item.view.*
import kotlinx.android.synthetic.main.notifications_item.view.*

class NotificationAdapter (var ma:MainActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: ArrayList<NotificationObject>
    init {
        list=MemoryAccesser(ma).getNotifications()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =   NotificationHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.notificationrem_item,
            parent,
            false
        )
    )

    override fun getItemCount(): Int= list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as NotificationHolder
        holder.body.text=list[position].body
        holder.head.text=list[position].head
        holder.from.text=list[position].datefrom
        holder.on.text=list[position].dateon
        holder.remove.setOnClickListener {
            list.removeAt(position)
            MemoryAccesser(ma).setNotifications(list)
            this.notifyDataSetChanged()
        }
    }

    inner class NotificationHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val body = root.ntbodyrem
        val head = root.ntheadrem
        val from = root.fromdtrem
        val on = root.todtrem
        val remove = root.remove

    }
}