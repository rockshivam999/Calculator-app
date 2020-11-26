package com.aptcoder.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class HistRecyclerAdapter(options: FirebaseRecyclerOptions<HistObj>) :
    FirebaseRecyclerAdapter<HistObj, HistRecyclerAdapter.HistRecyclerViewHolder>(options) {

    class  HistRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expression:TextView=itemView.findViewById(R.id.expression)
        val resultText:TextView=itemView.findViewById(R.id.resultText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistRecyclerViewHolder {
       return HistRecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false))
    }

    override fun onBindViewHolder(holder: HistRecyclerViewHolder, position: Int, model: HistObj) {
        holder.expression.text=model.expresion
        holder.resultText.text="= "+ model.Result
    }
}