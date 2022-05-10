package com.dev.myapplication.utils



object TimesHelper {

    fun isSecondsIlluminated(seconds : Int) : Boolean{
        var secondsIlluminated = false
        secondsIlluminated = seconds % 2 == 0

        return secondsIlluminated
    }

}