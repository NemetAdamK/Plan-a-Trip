package com.example.plan_a_trip.Classes

class Flights(_flightFrom: String,_flightTo:String,_flightPrice:Int,_departureTime: Int) {

    var flightFrom:String = ""
    var flightTo:String = ""
    var flightPrice:Int = 0
    var departureTime:Int = 0

    init {
        this.flightFrom=_flightFrom
        this.flightTo=_flightTo
        this.flightPrice=_flightPrice
        this.departureTime = _departureTime
    }


}