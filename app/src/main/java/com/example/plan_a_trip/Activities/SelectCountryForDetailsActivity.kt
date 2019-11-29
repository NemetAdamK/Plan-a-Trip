package com.example.plan_a_trip.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.plan_a_trip.R
import com.example.plan_a_trip.Globals.country
import com.example.plan_a_trip.Globals.countryID

class SelectCountryForDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_country_for_details)

        val btn_viewCountryDetailsList = findViewById<Button>(R.id.buttonViewDetails)

        var spinnerDestinationCountry = findViewById<Spinner>(R.id.spinnerDestinationCountry)


        setSpinner(spinnerDestinationCountry)


        btn_viewCountryDetailsList.setOnClickListener(){



            val intent = Intent(this, CountryDetailsActivity::class.java)
            intent.putExtra("CountryDescription", country[spinnerDestinationCountry.firstVisiblePosition])
            startActivity(intent)


        }
    }

    fun setSpinner(spinner: Spinner){
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            country
        )
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(aa)

        spinner?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                Toast.makeText( applicationContext,"Selected country : "+ country[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }
    }
}
