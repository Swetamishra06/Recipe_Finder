package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class newActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.hide()
        val fimage = intent.getIntExtra("image",R.drawable.jalebi)
        val fcontent = intent.getStringExtra("content")
        val imageview = findViewById<ImageView>(R.id.image1)
        val textview = findViewById<TextView>(R.id.text1)

       textview.text = fcontent
        imageview.setImageResource(fimage)
    }
}