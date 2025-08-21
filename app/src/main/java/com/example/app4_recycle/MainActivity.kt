package com.example.app4_recycle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app4_recycle.adapter.BukuAdapter
import com.example.app4_recycle.model.Buku
import com.example.app4recycle.com.example.app4_recycle.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvBuku: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBuku = findViewById(R.id.recyclerView)
        rvBuku.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getbuku().enqueue(object : Callback<List<Buku>> {
            override fun onResponse(call: Call<List<Buku>>, response: Response<List<Buku>>) {
                if (response.isSuccessful) {
                    rvBuku.adapter = BukuAdapter(response.body() ?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<Buku>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
