package com.example.plan_a_trip.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.plan_a_trip.R

class MainActivitySelect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_select)




    }


    fun showFlights(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun showDetails(view: View) {
        val intent = Intent(this,
            SelectCountryForDetailsActivity::class.java)
        startActivity(intent)
    }


}
