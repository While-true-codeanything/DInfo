package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.Adapters.MainAdapter
import com.example.dinfo.R
import kotlinx.android.synthetic.main.main_page.*

class MainPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        this.activity!!.MainContent.adapter =
            MainAdapter(activity as MainActivity)
        if (this.activity!!.MainContent.adapter != null) this.activity!!.MainContent.adapter?.notifyDataSetChanged()
    }

}
