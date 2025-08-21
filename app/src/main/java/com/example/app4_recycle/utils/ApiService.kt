package com.example.app4recycle.com.example.app4_recycle.utils

import com.example.app4_recycle.model.Buku
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET( value = "buku")
    fun getbuku(): Call<List<Buku>>
}