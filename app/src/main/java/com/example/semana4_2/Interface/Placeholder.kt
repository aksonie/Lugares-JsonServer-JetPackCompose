package com.example.semana4_2.Interface

import com.example.semana4_2.Beans.Sitios
import retrofit2.Response
import retrofit2.http.GET

interface Placeholder {
    @GET ("sitios.php")
    suspend fun getSitios():Response<List<Sitios>>
}