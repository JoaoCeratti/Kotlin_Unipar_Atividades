package com.example.filme

import Filme
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView

class FilmeAdapter(private val filmes: List<Filme>) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvGenero: TextView = itemView.findViewById(R.id.tvGenero)
        val tvAnoLancamento: TextView = itemView.findViewById(R.id.tvAnoLancamento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]

        holder.tvTitulo.text = filme.titulo
        holder.tvGenero.text = filme.genero
        holder.tvAnoLancamento.text = filme.anoLancamento.toString()

        // Definindo cores de fundo aleatórias
        val colors = listOf(
            Color.parseColor("#FFCCBC"), // Coral
            Color.parseColor("#BBDEFB"), // Azul claro
            Color.parseColor("#C8E6C9"), // Verde claro
            Color.parseColor("#FFF9C4")  // Amarelo claro
        )

        holder.itemView.setBackgroundColor(colors[position % colors.size])
    }

    override fun getItemCount(): Int {
        return filmes.size
    }
}