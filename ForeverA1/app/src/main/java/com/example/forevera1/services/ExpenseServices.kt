package com.example.forevera1.services

import com.example.forevera1.models.Expense
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.Path

interface ExpenseInterface {

    @GET("despesas/{municipio}/{exercicio}/{mes}")
    fun getExpenses(
        @Path("municipio") municipio: String,
        @Path("exercicio") exercicio: String,
        @Path("mes") mes: String
    ): Call<List<Expense>>

}

class ExpenseConnection {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://transparencia.tce.sp.gov.br/api/json/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create(ExpenseInterface::class.java)

}