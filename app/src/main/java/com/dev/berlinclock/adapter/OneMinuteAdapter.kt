package com.dev.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.dev.berlinclock.R


class OneMinuteAdapter(private val dataSet: Array<Boolean>) :
    RecyclerView.Adapter<OneMinuteAdapter.OneMinuteViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OneMinuteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.clock_items_blocks, parent, false)
        return OneMinuteViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: OneMinuteViewHolder, position: Int) {
        holder.bindItem(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class OneMinuteViewHolder(private val view: View) :
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