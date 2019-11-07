package com.example.plan_a_trip

import Json4Kotlin_Base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plan_a_trip.Adapters.FlightsAdapter
import com.example.plan_a_trip.Classes.Flights
import com.example.plan_a_trip.Retrofit.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_flight_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessController.getContext

class FlightListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_list)

        val flights : ArrayList<Flights> = ArrayList()
        recyclerView.addItemDecoration(
            DividerItemDecoration(applicationContext,
            DividerItemDecoration.VERTICAL)
        )
        recyclerView.layoutManager = LinearLayoutManager(this)

        val service = RetrofitClientInstance.retrofitInstance?.create(GetFlightService::class.java)
        val dataFlight = service?.getAllData()
        dataFlight?.enqueue(object: Callback<Json4Kotlin_Base> {
            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                Toast.makeText(applicationContext,"Error parsing json", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<Json4Kotlin_Base>,
                response: Response<Json4Kotlin_Base>
            ) {
                val body = response.body()
                for (element in body!!.data){
                    flights.add(Flights(element.cityFrom,element.cityTo,element.price,element.dTime))
                }

                recyclerView.adapter = FlightsAdapter(flights)

            }

        })
    }
}
