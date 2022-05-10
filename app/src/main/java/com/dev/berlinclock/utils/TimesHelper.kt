package com.dev.myapplication.utils

import com.dev.berlinclock.models.FiveMinutes


object TimesHelper {

    fun isSecondsIlluminated(seconds : Int) : Boolean{
        var secondsIlluminated = false
        secondsIlluminated = seconds % 2 == 0

        return secondsIlluminated
    }

    fun getOneMinuteIlluminated(minute: Int): Array<Boolean> {
        val oneMinutes : Array<Boolean> = Array(4){false}
        return oneMinutes
    }


    fun getFiveMinutesIlluminated(minutesInput : Int) : ArrayList<FiveMinutes> {
        val fiveMinutesList : ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0 .. 10){
        fiveMinutesList.add(FiveMinutes(false,i))
        }
        return fiveMinutesList
    }

}