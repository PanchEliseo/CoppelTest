package com.example.coppeltest.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coppeltest.databinding.ActivityWebviewBinding

class WebViewActivity: AppCompatActivity() {

    private lateinit var bindig: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityWebviewBinding.inflate(layoutInflater)
        val view = bindig.root
        setContentView(view)
        setView()
    }

    private fun setView(){
        bindig.webView.loadUrl("https://superheroapi.com/ids.html")
    }

}