package com.example.semana4_2.Modelo

import com.example.semana4_2.Interface.Placeholder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val placeHolder:Placeholder by lazy {
        Retrofit.Builder()
            .baseUrl("https://dev.formandocodigo.com/ServicioTour/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Placeholder::class.java)
    }
}