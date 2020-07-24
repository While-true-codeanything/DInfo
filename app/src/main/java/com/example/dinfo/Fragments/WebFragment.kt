package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.dinfo.R
import kotlinx.android.synthetic.main.web_page.*


class WebFragment(var url: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.web_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        web.settings.javaScriptEnabled = true
        web.loadUrl(url)
        web.setWebViewClient(CustomWebViewClient())
    }

    private class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            view.loadUrl(url)
            return true
        }
    }

}
