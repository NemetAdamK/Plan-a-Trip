package com.example.plan_a_trip.Activities

import Json4Kotlin_Base_Details
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plan_a_trip.Adapters.DetailsAdapter
import com.example.plan_a_trip.Classes.CountryDetails
import com.example.plan_a_trip.Interfaces.GetCountryDescription
import com.example.plan_a_trip.R
import com.example.plan_a_trip.Retrofit.RetrofitClientInstanceCountryDetails
import kotlinx.android.synthetic.main.activity_country_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.ClipData.Item
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import com.google.gson.Gson
import java.lang.Exception


class CountryDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val details : ArrayList<CountryDetails> = ArrayList()
        recyclerViewDetails.addItemDecoration(
            DividerItemDecoration(applicationContext,
                DividerItemDecoration.VERTICAL)
        )
        recyclerViewDetails.layoutManager = LinearLayoutManager(this)

        val countryTo = intent.getStringExtra("CountryDescription")
        val service = RetrofitClientInstanceCountryDetails.retrofitInstance?.create(GetCountryDescription::class.java)
        Toast.makeText(applicationContext,countryTo, Toast.LENGTH_LONG).show()
        val dataFlight = service?.getAllCountryData(countryTo!!)

        dataFlight?.enqueue(object: Callback<List<Json4Kotlin_Base_Details>> {

            override fun onFailure(call: Call<List<Json4Kotlin_Base_Details>>, t: Throwable) {
                Log.v("Tag",t.toString())
                Toast.makeText(applicationContext,"Error parsing json", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<Json4Kotlin_Base_Details>>,
                response: Response<List<Json4Kotlin_Base_Details>>
            ) {
                val body = response.body()
                var countryName: String = ""
                var countryCapital: String = ""
                var countryRegion: String= ""
                var countrySubRegion: String = ""
                var countryCurrency = ArrayList<String>()
                var countryBorders = ArrayList<String>()

                try {
                    for (e in body!!) {
                        countryName = e.name
                        countryCapital = e.capital
                        countryRegion = e.region
                        countrySubRegion = e.subregion
                        for (currency in e.currencies) {
                            countryCurrency?.add(currency.name)
                        }
                        for (borders in e.borders) {
                            countryBorders?.add(borders)
                        }
                    }
                } catch (e:Exception){
                    Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_SHORT).show()
                }

                details.add(CountryDetails(countryName,countryCapital,countryRegion,countrySubRegion,countryCurrency,countryBorders))

                if (details.size == 0){
                    Toast.makeText(applicationContext,"No data to be shown", Toast.LENGTH_SHORT).show()
                }
                recyclerViewDetails.adapter = DetailsAdapter(details)

            }

        })
    }
}

