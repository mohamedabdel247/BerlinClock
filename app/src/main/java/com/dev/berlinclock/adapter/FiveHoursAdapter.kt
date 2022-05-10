package com.dev.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.content.res.AppCompatResources
import com.dev.berlinclock.R


class FiveHoursAdapter(private val dataSet: Array<Boolean>) :
    RecyclerView.Adapter<FiveHoursAdapter.FiveHoursViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FiveHoursViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.clock_items_blocks, parent, false)
        return FiveHoursViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: FiveHoursViewHolder, position: Int) {
        holder.bindItem(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class FiveHoursViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        private val viHourOrMinutes: View = view.findViewById(R.id.vi_HourOrMinutes)
        fun bindItem(item: Boolean) {
            if (item) {
                viHourOrMinutes.background =
                    AppCompatResources.getDrawable(view.context, R.drawable.red_rect_bg)
            } else {
                viHourOrMinutes.background =
                    AppCompatResources.getDrawable(view.context, R.drawable.normal_rect_bg)
            }
        }
    }
}