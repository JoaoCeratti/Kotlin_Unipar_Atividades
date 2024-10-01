package com.example.adaptersystem

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var textViewQuantidade: TextView
    private var listaAlunos = mutableListOf<Aluno>()
    private lateinit var alunoAdapter: AlunoAdapter // Declare o adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNomeAluno = findViewById<EditText>(R.id.editTextNomeAluno)
        val editTextAreaEscolha = findViewById<EditText>(R.id.editTextAreaEscolha)
        val buttonInserir = findViewById<Button>(R.id.buttonInserir)
        val buttonZerar = findViewById<Button>(R.id.buttonZerar)
        textViewQuantidade = findViewById(R.id.textViewQuantidade)
        recyclerView = findViewById(R.id.recyclerViewAlunos)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicialize o adapter e defina para o RecyclerView
        alunoAdapter = AlunoAdapter(listaAlunos)
        recyclerView.adapter = alunoAdapter

        // Adicionar aluno à lista
        buttonInserir.setOnClickListener {
            val nome = editTextNomeAluno.text.toString()
            val areaEscolha = editTextAreaEscolha.text.toString()
            val dataAtual = getCurrentDate()

            if (nome.isNotEmpty() && areaEscolha.isNotEmpty()) {
                listaAlunos.add(Aluno(nome, areaEscolha, dataAtual))
                atualizarQuantidadeAlunos()
                alunoAdapter.notifyItemInserted(listaAlunos.size - 1) // Notifica a inserção do novo item
                editTextNomeAluno.text.clear()
                editTextAreaEscolha.text.clear()
            }
        }

        // Zerar lista
        buttonZerar.setOnClickListener {
            listaAlunos.clear()
            alunoAdapter.notifyDataSetChanged() // Notifica que a lista foi atualizada
            atualizarQuantidadeAlunos()
        }
    }

    // Atualizar a quantidade de alunos exibida
    private fun atualizarQuantidadeAlunos() {
        textViewQuantidade.text = "${listaAlunos.size} Alunos"
    }

    // Função para obter a data atual
    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd/MM", Locale.getDefault())
        return sdf.format(Date())
    }
}