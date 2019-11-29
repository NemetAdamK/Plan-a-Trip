package com.example.plan_a_trip.Classes

class CountryDetails(_name: String,_capital:String,_region:String,_subRegion: String,_currency: ArrayList<String>,_countryBorders: ArrayList<String>) {

    var name:String = ""
    var capital:String = ""
    var region:String = ""
    var subregion:String = ""
    var currency : ArrayList<String> = ArrayList()
    var countryBorders: ArrayList<String> = ArrayList<String>()

    init {
        this.name=_name
        this.capital=_capital
        this.region=_region
        this.subregion = _subRegion
        this.currency = _currency
        this.countryBorders = _countryBorders
    }
}