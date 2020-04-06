//各部署をExpandableListViewで表示

package com.example.konzatu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.widget.Adapter
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import com.example.konzatu.BusyoExpandableListAdapter
import com.example.konzatu.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.text.observe(this, Observer {

        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      val mExpandableListAdapter= BusyoExpandableListAdapter(context!!)
        val expandableListView:ExpandableListView=view.findViewById(R.id.expandableListview)
        expandableListView.setAdapter(mExpandableListAdapter)

    }




}