package com.dev.berlinclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.berlinclock.databinding.ActivityMainBinding
import com.dev.berlinclock.models.FiveMinutes
import com.dev.myapplication.adapters.FiveHoursAdapter
import com.dev.myapplication.adapters.FiveMinutesAdapter
import com.dev.myapplication.adapters.OneHourAdapter
import com.dev.myapplication.adapters.OneMinuteAdapter
import com.dev.myapplication.utils.TimesHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isSecondsIlluminted: Boolean = TimesHelper.isSecondsIlluminated(19)
        val fiveHoursData: Array<Boolean> = TimesHelper.getFiveHoursIlluminated(17)
        val oneHoursData: Array<Boolean> = TimesHelper.getOneHourIlluminated(17)
        val fiveMinutesData: ArrayList<FiveMinutes> = TimesHelper.getFiveMinutesIlluminated(53)
        val oneMinuteData: Array<Boolean> = TimesHelper.getOneMinuteIlluminated(53)
        Log.e("secondsFlag", isSecondsIlluminted.toString())
        if (isSecondsIlluminted) {
            binding.viSeconds.background =
                AppCompatResources.getDrawable(baseContext, R.drawable.sec_circle_bg)
        }else{
            binding.viSeconds.background =
                AppCompatResources.getDrawable(baseContext, R.drawable.white_circle_bg)
        }
        val fiveHoursAdapter = FiveHoursAdapter(fiveHoursData)
        val oneHoursAdapter = OneHourAdapter(oneHoursData)
        val fiveMinutesAdapter = FiveMinutesAdapter(fiveMinutesData)
        val oneMinuteAdapter = OneMinuteAdapter(oneMinuteData)

        binding.rvFiveHours.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapter = fiveHoursAdapter
        }
        binding.rvOneHours.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapter = oneHoursAdapter
        }
        binding.rvFiveMinutes.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 11)
            adapter = fiveMinutesAdapter
        }
        binding.rvOneMinutes.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapter = oneMinuteAdapter
        }
    }
}