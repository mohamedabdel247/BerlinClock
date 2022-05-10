package com.dev.myapplication.utils

import com.dev.berlinclock.models.FiveMinutes


object TimesHelper {

    fun isSecondsIlluminated(seconds : Int) : Boolean{
        var secondsIlluminated = false
        secondsIlluminated = seconds % 2 == 0

        return secondsIlluminated
    }

    fun getOneMinuteIlluminated(minute: Int): Array<Boolean> {
        val arraySize = 4
        var oneMinutesArray = Array(arraySize){false}
        if (minute % 5 !=0){
            val oneMinutesCount = minute % 5
            for (i in 0 until oneMinutesCount){
                oneMinutesArray[i] = true
            }
        }else{
            oneMinutesArray = Array(arraySize){false}
        }

        return oneMinutesArray
    }


    fun getFiveMinutesIlluminated(minutesInput : Int) : ArrayList<FiveMinutes> {
        val lambCount = 11
        val maxMinutesFirstRow = 55
        val minutesPerBlock = 5
        val fiveMinutesList : ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0 until lambCount){
            fiveMinutesList.add(
                FiveMinutes(
                    false,
                    i
                )
            )
        }
        var fiveMinutesCount = minutesInput
        if (fiveMinutesCount > maxMinutesFirstRow) {
            fiveMinutesCount = maxMinutesFirstRow/minutesPerBlock
        }else{
            fiveMinutesCount /= minutesPerBlock
        }
        for (i in 0 until  fiveMinutesCount){
            fiveMinutesList[i] = FiveMinutes(true,
                i
            )
        }
        return fiveMinutesList
    }

}