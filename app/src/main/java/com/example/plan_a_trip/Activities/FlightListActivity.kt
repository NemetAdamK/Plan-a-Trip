package com.example.plan_a_trip.Activities

import Json4Kotlin_Base_Flights
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plan_a_trip.Adapters.FlightsAdapter
import com.example.plan_a_trip.Classes.Flights
import com.example.plan_a_trip.Interfaces.GetFlightService
import com.example.plan_a_trip.R
import com.example.plan_a_trip.Retrofit.RetrofitClientInstanceFlight
import kotlinx.android.synthetic.main.activity_flight_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


        val countryFrom = intent.getStringExtra("CountryFrom")
        val countryTo = intent.getStringExtra("CountryTo")
        val dateFrom = intent.getStringExtra("DateFrom")
        val dateTo = intent.getStringExtra("DateTo")
        val service = RetrofitClientInstanceFlight.retrofitInstance?.create(GetFlightService::class.java)
        val dataFlight = service?.getAllData(countryFrom!!,countryTo!!,dateFrom!!,dateTo!!,"picky")
        dataFlight?.enqueue(object: Callback<Json4Kotlin_Base_Flights> {
            override fun onFailure(call: Call<Json4Kotlin_Base_Flights>, t: Throwable) {
                Toast.makeText(applicationContext,"Error parsing json", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<Json4Kotlin_Base_Flights>,
                response: Response<Json4Kotlin_Base_Flights>
            ) {
                val body = response.body()

                for (element in body!!.data){
                    flights.add(Flights(element.cityFrom,element.cityTo,element.price,element.dTime))
                }

                if (flights.size == 0){
                    Toast.makeText(applicationContext,"No data to be shown",Toast.LENGTH_SHORT).show()
                }
                recyclerView.adapter = FlightsAdapter(flights)

            }

        })
    }
}
