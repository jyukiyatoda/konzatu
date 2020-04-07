package com.example.konzatu.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.widget.AdapterView
import android.widget.ListView
import com.example.konzatu.ListViewAdapter
import com.example.konzatu.R
import com.example.konzatu.SubActivity

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    val infosub= mutableListOf<String>(
        "新着情報はありません",
        "新着情報はありません",
        "新着情報はありません",
        "新着情報はありません",
        "新着情報はありません"
    )
    val photosub= mutableListOf<Int>(
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        notificationsViewModel.text.observe(this, Observer {

        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mListViewAdapter= ListViewAdapter(context!!)
        val listView:ListView=view.findViewById(R.id.list_view)
        listView.adapter=mListViewAdapter

        listView.setOnItemClickListener({adapterView:AdapterView<*>,view1:View,position:Int,l:Long ->
            val intent= Intent(getActivity(), SubActivity::class.java)
            var selectedText:String=infosub[position]
            var selectedPhoto:Int=photosub[position]

            intent.putExtra("Text",selectedText)
            intent.putExtra("Photo",selectedPhoto)
            startActivity(intent)

        })
    }
}