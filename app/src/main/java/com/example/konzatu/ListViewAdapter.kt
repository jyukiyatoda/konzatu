package com.example.konzatu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter (val context: Context):BaseAdapter(){
    var inflater:LayoutInflater= LayoutInflater.from(context)

    var information= mutableListOf<String>(
        "新着情報はありません",
        "新着情報はありません",
        "新着情報はありません",
        "新着情報はありません",
        "新着情報はありません"
    )
    var phots= mutableListOf<Int>(
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp
    )
    override fun getCount(): Int {
        return information.size
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any {
        return information[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val view:View=convertView ?:inflater.inflate(R.layout.list_item,null)
        val imageView=view.findViewById<ImageView>(R.id.imagelistView)
        imageView.setImageResource(phots[position])

        var textView=view.findViewById<TextView>(R.id.textlistView)
        textView.setText(information[position])

        return view
    }


}