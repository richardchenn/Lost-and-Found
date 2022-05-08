package com.example.lostandfound

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AddItemAdapter(mContext: Context,sharedPreferences: SharedPreferences): RecyclerView.Adapter<AddItemAdapter.ViewHolder>() {

    var context = mContext
    //var lostItem = item
    //var lostDate = date
    //var lostDesc = desc
    //var items : ArrayList<String>? = null

    private val mItems = ArrayList<LostItem>()

    fun add(item: LostItem){
        mItems.add(item)
        notifyItemChanged(mItems.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.activity_itemadapter, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val lostItemTemp = mItems[position]

            holder.mItemView!!.text = lostItemTemp.item
            holder.mDateView!!.text = lostItemTemp.date
            holder.mDescView!!.text = lostItemTemp.desc

    }

    class ViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v) {

        var mItemView: TextView? = itemView.findViewById(R.id.displayItemTitle)
        var mDateView: TextView? = itemView.findViewById(R.id.displayDate)
        var mDescView: TextView? = itemView.findViewById(R.id.displayDescription)

    }

    override fun getItemCount(): Int {
        return mItems.size
    }

}