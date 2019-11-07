package com.example.plan_a_trip

import Data
import Json4Kotlin_Base
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.plan_a_trip.Retrofit.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_viewList = findViewById<Button>(R.id.buttonViewList)

        btn_viewList.setOnClickListener(){
            var intent = Intent(this,FlightListActivity::class.java)
            startActivity(intent)
        }


    }
}
