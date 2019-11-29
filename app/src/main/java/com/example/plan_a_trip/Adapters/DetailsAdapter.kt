package com.example.plan_a_trip.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plan_a_trip.Classes.CountryDetails
import com.example.plan_a_trip.Classes.Flights
import com.example.plan_a_trip.R

class DetailsAdapter(val details: ArrayList<CountryDetails>): RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.detailName.text = "Country name: ".plus(details[position].name)
        holder.detailCapital.text = "Country capital: ".plus(details[position].capital)
        holder.detailRegion.text = "Country region: ".plus(details[position].region)
        holder.detailSubRegion.text = "Country subregion: ".plus(details[position].subregion)
        holder.detailCurrency.text = "Country currencyes: ".plus(details[position].currency)
        holder.detailBorders.text = "Country borders: ".plus(details[position].countryBorders)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.detailslist_row,parent,false)
        return DetailsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return details.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val detailName: TextView = itemView.findViewById(R.id.textViewName)
        val detailCapital: TextView = itemView.findViewById(R.id.textViewCapital)
        val detailRegion: TextView = itemView.findViewById(R.id.textViewRegion)
        val detailSubRegion: TextView = itemView.findViewById(R.id.textViewSubRegion)
        val detailCurrency: TextView = itemView.findViewById(R.id.textViewCurrencies)
        val detailBorders: TextView = itemView.findViewById(R.id.textViewBorders)

    }
}