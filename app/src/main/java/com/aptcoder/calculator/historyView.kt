package com.aptcoder.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aptcoder.calculator.databinding.ActivityHistoryViewBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class historyView : AppCompatActivity() {
 private lateinit var histActvity:ActivityHistoryViewBinding
    private lateinit var adapter:HistRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        histActvity=DataBindingUtil.setContentView(this,R.layout.activity_history_view)
        histActvity.historyRecycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
       val option:FirebaseRecyclerOptions<HistObj> = FirebaseRecyclerOptions.Builder<HistObj>().setQuery(
           FirebaseDatabase.getInstance().reference.child("CalcHist").orderByChild("dateToOrder"),HistObj::class.java).build()
        adapter= HistRecyclerAdapter(option)
        histActvity.historyRecycler.adapter=adapter


    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }
}