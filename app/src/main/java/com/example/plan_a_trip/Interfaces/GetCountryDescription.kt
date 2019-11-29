package com.example.plan_a_trip.Interfaces

import Json4Kotlin_Base_Details
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GetCountryDescription {
    @GET("/rest/v2/name/{name}")

    fun getAllCountryData(@Path("name") name: String): Call<List<Json4Kotlin_Base_Details>>


}