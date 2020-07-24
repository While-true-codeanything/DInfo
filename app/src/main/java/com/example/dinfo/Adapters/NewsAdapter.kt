package com.example.dinfo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.DtClassesAndOth.AllAppData
import com.example.dinfo.Fragments.WebFragment
import com.example.dinfo.R
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(var ma: MainActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        NewsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = AllAppData.News.articles.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as NewsHolder
        holder.date.text = AllAppData.News.articles[position].title
        holder.date.setOnClickListener {
            ma.loadFragment(WebFragment(AllAppData.News.articles[position].url))
        }
    }

    inner class NewsHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val date = root.NewsInfo
    }
}