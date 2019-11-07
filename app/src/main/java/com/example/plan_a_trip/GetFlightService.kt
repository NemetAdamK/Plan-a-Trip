package com.example.plan_a_trip

import Data
import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET


interface GetFlightService {
    @GET("/flights?flyFrom=RO&to=HU&dateFrom=18/11/2019&dateTo=12/12/2019&partner=picky")
    fun getAllData(): Call<Json4Kotlin_Base>
}