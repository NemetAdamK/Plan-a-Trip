package com.example.plan_a_trip.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plan_a_trip.Classes.Flights
import com.example.plan_a_trip.R
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList
import android.text.format.DateFormat
import java.sql.Timestamp
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME






class FlightsAdapter(val flights: ArrayList<Flights>): RecyclerView.Adapter<FlightsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightsAdapter.ViewHolder {
       val view: View = LayoutInflater.from(parent.context).inflate(R.layout.flightslist_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return flights.size
    }

    override fun onBindViewHolder(holder: FlightsAdapter.ViewHolder, position: Int) {
        holder.flightFrom.text = flights[position].flightFrom
        holder.flightTo.text = flights[position].flightTo
        holder.flightPrice.text = flights[position].flightPrice.toString().plus(" Eur")
        holder.flightsDeparture.text = getDateTime(flights[position].departureTime)
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val flightFrom: TextView = itemView.findViewById(R.id.textViewFlightFrom)
        val flightTo: TextView = itemView.findViewById(R.id.textViewFlightTo)
        val flightPrice: TextView = itemView.findViewById(R.id.textViewFlightPrice)
        val flightsDeparture: TextView = itemView.findViewById(R.id.textViewDepartureTime)

    }

    private fun getDateTime(s: Int): String? {

        try {
            val time = Timestamp(s.toLong()*1000);
            val date = Date(time.getTime())
            val cal = Calendar.getInstance()
            cal.time = date
            val hours = cal.get(Calendar.HOUR_OF_DAY).toString()
            val minutes = cal.get(Calendar.MINUTE).toString()
            val year = cal.get(Calendar.YEAR).toString()
            val monthString = SimpleDateFormat("MMMM").format(cal.getTime())
            val month = cal.get(Calendar.MONTH).toString()
            val day = cal.get(Calendar.DAY_OF_MONTH).toString()
            val stringDate = "$year/$monthString/$day $hours:$minutes"
            return stringDate
        } catch (e: Exception) {
            return e.toString()
        }
    }

}