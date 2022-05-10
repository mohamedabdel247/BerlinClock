package com.dev.berlinclock

import com.dev.berlinclock.models.FiveMinutes
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

    @Test
    fun `test full minutes should return Illuminated lamps`() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(59)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(59)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = true, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(true,true,true,true)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test zero minutes should return white lamps`() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(0)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(0)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(false,false,false,false)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test full five minutes should return Illuminated lamps and one minutes should return white lamps `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(55)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(55)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = true, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(false,false,false,false)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test full five minutes should return white lamps and one minutes should return Illuminated lamps `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(4)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(4)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(true,true,true,true)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test full five minutes should return white lamps and one minutes should return two Illuminated lamps `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(2)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(2)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(true,true,false,false)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test three lamps of five minutes should Illuminated lamps and one minutes should return one Illuminated lamp `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(16)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(16)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..2) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = true, lambId = i))
        }
        for (i in 3..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(true,false,false,false)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test two lamps of five minutes should Illuminated lamps and one minutes should return three Illuminated lamps `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(13)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(13)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..1) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = true, lambId = i))
        }
        for (i in 2..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(true,true,true,false)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test six lamps of five minutes should Illuminated lamps and one minutes should return four Illuminated lamps `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(34)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(34)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..5) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = true, lambId = i))
        }
        for (i in 6..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(true,true,true,true)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

    @Test
    fun `test eight lamps of five minutes should Illuminated lamps and one minutes should return zero Illuminated lamps `() {
        val fiveMinutesResult = TimesHelper.getFiveMinutesIlluminated(40)
        val oneMinutesResult = TimesHelper.getOneMinuteIlluminated(40)

        val fiveMinutesExpected :ArrayList<FiveMinutes> = arrayListOf()
        for (i in 0..7) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = true, lambId = i))
        }
        for (i in 8..10) {
            fiveMinutesExpected.add(FiveMinutes(lambStatus = false, lambId = i))
        }
        val oneMinutesExpected :Array<Boolean> = arrayOf(false,false,false,false)

        Assert.assertEquals(fiveMinutesExpected, fiveMinutesResult)
        Assert.assertArrayEquals(oneMinutesExpected, oneMinutesResult)
    }

}