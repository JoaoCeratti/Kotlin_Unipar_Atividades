package com.example.adaptersystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunoAdapter(private val listaAlunos: List<Aluno>) :
    RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    // ViewHolder: representa cada item da lista
    class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNome: TextView = itemView.findViewById(R.id.textViewNome)
        val textViewAreaEscolha: TextView = itemView.findViewById(R.id.textViewAreaEscolha)
        val textViewDataAtual: TextView = itemView.findViewById(R.id.textViewDataAtual)
    }

    // Inflar o layout de cada item (criar a view para cada item)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_aluno, parent, false)
        return AlunoViewHolder(view)
    }

    // Vincular os dados aos elementos visuais
    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = listaAlunos[position]
        holder.textViewNome.text = aluno.nome
        holder.textViewAreaEscolha.text = aluno.areaEscolha
        holder.textViewDataAtual.text = aluno.dataAtual
    }

    // Retornar o tamanho da lista
    override fun getItemCount(): Int {
        return listaAlunos.size
    }
}