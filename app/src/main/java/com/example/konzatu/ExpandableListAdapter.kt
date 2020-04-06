package com.example.konzatu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class BusyoExpandableListAdapter(var context: Context):BaseExpandableListAdapter() {
    val mLayoutInflater:LayoutInflater= LayoutInflater.from(context)


    val header= mutableListOf("市民課","子育て支援課","福祉課","税務課","総務課")
    val body
        get() = mutableListOf(siminka,kosodatesienka,hukusika,zeimuka,soumuka)
    val phots
        get()= mutableListOf(simin_photo,kosodate_photo,hukusi_photo,zeimu_photo,soumu_photo)


    val siminka= mutableListOf(
        "市民係",
        "国民健康保険係")
    val kosodatesienka= mutableListOf(
        "子育て支援係",
        "保育係")
    val hukusika= mutableListOf(
        "福祉係",
        "障がい者福祉係",
        "高齢者福祉係")
    val zeimuka= mutableListOf(
        "固定資産税係",
        "市民税係",
        "収税係")
    val soumuka= mutableListOf(
        "総務係",
        "人事係",
        "財政係",
        "防災庶務係",
        "企画係",
        "秘書広報係")

    val simin_photo=mutableListOf(
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp
    )
    val kosodate_photo= mutableListOf(
        R.drawable.ic_sentiment_satisfied_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp
    )
    val hukusi_photo= mutableListOf(
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp
    )
    val zeimu_photo= mutableListOf(
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp
    )
    val soumu_photo= mutableListOf(
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp,
        R.drawable.ic_sentiment_neutral_black_24dp
    )


    //親要素の数を返す
    override fun getGroupCount(): Int {
        return header.size
    }
    //子要素の数を返す
    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }
    //親要素を取得
    override fun getGroup(groupPosition: Int): String {
        return header[groupPosition]
    }
    //子要素を取得
    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return 0
    }
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
     return 0
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    //親要素のレイアウト生成
    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View{
        val view:View=convertView ?:mLayoutInflater.inflate(R.layout.listitem_section,null)
        val textviewSection=view.findViewById<TextView>(R.id.listitem_section)
        textviewSection.text=header.get(groupPosition)

        return view

    }
    //子要素のレイアウト生成
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view:View=convertView ?:mLayoutInflater.inflate(R.layout.listitem_low,null)
        val textviewRow=view.findViewById<TextView>(R.id.listitem_low)
        textviewRow.text=body.get(groupPosition).get(childPosition)

        val imageView=view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(phots[groupPosition][childPosition])
        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }


}