package com.example.toko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toko.FunctionHelper.rupiahFormat
import com.example.toko.model.ModelDatabase

class HistoryAdapter(var modelDatabase: MutableList<ModelDatabase>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    fun setDataAdapter(items: List<ModelDatabase>) {
        modelDatabase.clear()
        modelDatabase.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelDatabase[position]
        holder.tvItems.setText(data.totalItems)
        holder.tvPrice.setText(rupiahFormat(data.totalPrice))
    }

    override fun getItemCount(): Int {
        return modelDatabase.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItems = itemView.findViewById<TextView>(R.id.tvItems)
        var tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)

    }

    fun setSwipeRemove(position: Int): ModelDatabase {
        return modelDatabase.removeAt(position)
    }

}