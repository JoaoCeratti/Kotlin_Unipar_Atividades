package com.example.adaptersystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultadosAdapter(private val resultados: List<String>) : RecyclerView.Adapter<ResultadosAdapter.ResultadoViewHolder>() {

    // ViewHolder para o item do RecyclerView
    class ResultadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewResultado: TextView = itemView.findViewById(R.id.textViewResultado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultadoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_resultado, parent, false)
        return ResultadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultadoViewHolder, position: Int) {
        holder.textViewResultado.text = resultados[position]
    }

    override fun getItemCount(): Int {
        return resultados.size
    }
}