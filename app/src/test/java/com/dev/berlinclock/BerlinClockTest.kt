package com.dev.berlinclock

import com.dev.myapplication.utils.TimesHelper
import org.junit.Assert
import org.junit.Test

class BerlinClockTest {

    @Test
    fun `test even seconds should return red lamp color`() {
        val result = TimesHelper.isSecondsIlluminated(2)

        val expectedResult = true
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `test odd seconds should return white lamp color`() {
        val result = TimesHelper.isSecondsIlluminated(59)

        val expectedResult = false
        Assert.assertEquals(expectedResult, result)
    }

}