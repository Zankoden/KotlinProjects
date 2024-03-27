package com.example.myfirstkotlinapplication

import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClick: Button = findViewById(R.id.btnClick)
        btnClick.setOnClickListener {
            // Display a toast message when the "You lazyass, find it yourself!" button is clicked
            showToast("You lazyass, find it yourself!")
        }

        val readButton: Button = findViewById(R.id.btnRead)
        readButton.setOnClickListener {
            // Load the PDF file when the "READ" button is clicked
            loadPdf()
        }

        val secondButton = findViewById<Button>(R.id.buttopage2)
        secondButton.setOnClickListener {
            // Open the second activity when the "DEMO NEXT PAGE" button is clicked
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun loadPdf() {
        val pdfWebView: WebView = findViewById(R.id.pdfWebView)

        // Clear WebView cache
        pdfWebView.clearCache(true) // Pass true or false based on your requirement

        pdfWebView.settings.javaScriptEnabled = true
        pdfWebView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        pdfWebView.webViewClient = WebViewClient()

        // Load PDF file from assets
        val pdfFileName = "sample.pdf" // Replace with your PDF file name
        val pdfPath = "file:///android_asset/$pdfFileName"
        pdfWebView.loadUrl(pdfPath)
    }



}
