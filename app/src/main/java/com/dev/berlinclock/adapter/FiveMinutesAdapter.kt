package com.dev.myapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.dev.berlinclock.R
import com.dev.berlinclock.models.FiveMinutes

class FiveMinutesAdapter(private val dataSet: List<FiveMinutes>) :
    RecyclerView.Adapter<FiveMinutesAdapter.FiveMinutesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiveMinutesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.five_minutes_items, parent, false)
        return FiveMinutesViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: FiveMinutesViewHolder, position: Int) {

        holder.bindItem(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class FiveMinutesViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        private val viHourOrMinutes: View = view.findViewById(R.id.vi_fiveMinutes)
        fun bindItem(item: FiveMinutes) {
            if (item.lambStatus) {
                val lambIds = item.lambId+1
                Log.e("poss",lambIds.toString())
                if (lambIds % 3 == 0 && lambIds != 0) {
                    Log.e("pos",adapterPosition.toString())
                    viHourOrMinutes.background =
                        AppCompatResources.getDrawable(view.context, R.drawable.red_rect_bg)
                }else{
                    viHourOrMinutes.background =
                        AppCompatResources.getDrawable(view.context, R.drawable.yellow_rect_bg)
                }
            } else {
                viHourOrMinutes.background =
                    AppCompatResources.getDrawable(view.context, R.drawable.normal_rect_bg)
            }
        }
    }
}