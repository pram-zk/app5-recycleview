package com.example.app4_recycle

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detail : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvTitle = findViewById(R.id.tvTitledet)
        val tvAutor = findViewById<TextView>(R.id.tvAuthordet)
        val tvYear = findViewById<TextView>(R.id.tvYear)

        val Title = intent.getStringExtra("judul")
        val Author = intent.getStringExtra("author")
        val Year = intent.getIntExtra("year", 0).toString()

        tvTitle.text = Title
        tvAutor.text = Author
        tvYear.text = Year
    }
}