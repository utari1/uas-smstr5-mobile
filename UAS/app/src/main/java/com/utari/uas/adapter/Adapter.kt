package com.utari.uas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utari.uas.Model
import com.utari.uas.R

class Adapter (
    val stok: ArrayList<Model.Data>
): RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data = stok[position]
        holder.textNama.text = data.nama
        holder.textBrand.text = data.brand
    }

    override fun getItemCount() = stok.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNama = view.findViewById<TextView>(R.id.textnama)
        val textBrand = view.findViewById<TextView>(R.id.textbrand)
    }
    public fun setData(data: List<Model.Data>){
        stok.clear()
        stok.addAll(data)
        notifyDataSetChanged()
    }

}