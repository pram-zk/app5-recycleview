package com.example.app4recycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app4_recycle.R
import com.example.app4recycle.adapter.BookAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private val bookList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Data awal buku
        bookList.add(Book("Laskar Pelangi", "Andrea Hirata", 2005))
        bookList.add(Book("Bumi", "Tere Liye", 2014))
        bookList.add(Book("Negeri 5 Menara", "Ahmad Fuadi", 2009))
        bookList.add(Book("Keren", "Iam", 2000))
        bookList.add(Book("Bangso", "Yadi", 2002))

        // Gunakan this untuk context dan bookList untuk data
        bookAdapter = BookAdapter(this, bookList)
        recyclerView.adapter = bookAdapter
    }
}
