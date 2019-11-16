package com.example.plan_a_trip

import Data
import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GetFlightService {
    @GET("/flights")

    fun getAllData(@Query("flyFrom") user: String, @Query("to") to: String, @Query("dateFrom") dateFrom: String, @Query("dateTo") dateTo: String, @Query("partner") partner: String): Call<Json4Kotlin_Base>




}