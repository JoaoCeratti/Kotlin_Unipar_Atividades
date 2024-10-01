package com.example.adaptersystem

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptersystem.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var resultadosAdapter: ResultadosAdapter
    private val resultados = mutableListOf<String>() // Lista de resultados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNumeroDeHomens = findViewById<EditText>(R.id.et_homens)
        val editNumeroDeMulheres = findViewById<EditText>(R.id.et_mulheres)
        val editNumeroDeCriancas = findViewById<EditText>(R.id.et_criancas)
        val buttonCalculo = findViewById<Button>(R.id.btn_calcular)
        val buttonZerar = findViewById<Button>(R.id.btn_limpar)

        // Inicializando RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        resultadosAdapter = ResultadosAdapter(resultados)
        recyclerView.adapter = resultadosAdapter

        // Adicionar aluno à lista
        buttonCalculo.setOnClickListener {
            val homenst = editNumeroDeHomens.text.toString()
            val mulherest = editNumeroDeMulheres.text.toString()
            val criancast = editNumeroDeCriancas.text.toString()

            if (homenst.isEmpty() && mulherest.isEmpty() && criancast.isEmpty()) {
                showToast("Por favor, preencha pelo menos um campo.")
            } else {
                calcularParticipantes(homenst, mulherest, criancast)
            }
        }

        // Zerar lista
        buttonZerar.setOnClickListener {
            clearInputs()
        }
    }

    private fun calcularParticipantes(homenst: String, mulherest: String, criancast: String) {
        val bonusPercent = 0.1f

        val homens = homenst.toFloatOrNull() ?: 0f
        val mulheres = mulherest.toFloatOrNull() ?: 0f
        val criancas = criancast.toFloatOrNull() ?: 0f

        val carneTotal = (homens * 400 + homens * 400 * bonusPercent) +
                (mulheres * 300 + mulheres * 300 * bonusPercent) +
                (criancas * 200 + criancas * 200 * bonusPercent)

        val aperitivoTotal = (homens * 150 + homens * 150 * bonusPercent) +
                (mulheres * 100 + mulheres * 100 * bonusPercent) +
                (criancas * 50 + criancas * 50 * bonusPercent)

        val alcoolTotal = (homens * 4 + homens * 4 * bonusPercent) +
                (mulheres * 2 + mulheres * 2 * bonusPercent)

        val aguaTotal = (criancas + mulheres) * 2 + (criancas + mulheres) * 2 * bonusPercent
        val refriTotal = (criancas + mulheres) * 2 + (criancas + mulheres) * 2 * bonusPercent

        val bebidasTotal = alcoolTotal + aguaTotal + refriTotal

        resultados.clear() // Limpa a lista antes de adicionar novos resultados
        resultados.add("Total de Carne: ${carneTotal}g")
        resultados.add("Total de Aperitivos: ${aperitivoTotal}g")
        resultados.add("Total de Bebidas Alcoólicas: ${alcoolTotal}L")
        resultados.add("Total de Água: ${aguaTotal}L")
        resultados.add("Total de Refrigerante: ${refriTotal}L")
        resultados.add("Total de Bebidas: ${bebidasTotal}L")

        // Notifica o adapter que a lista foi atualizada
        resultadosAdapter.notifyDataSetChanged()
    }

    private fun clearInputs() {
        findViewById<EditText>(R.id.et_homens).setText("")
        findViewById<EditText>(R.id.et_mulheres).setText("")
        findViewById<EditText>(R.id.et_criancas).setText("")
        resultados.clear() // Limpa a lista de resultados
        resultadosAdapter.notifyDataSetChanged() // Atualiza o adapter
    }

    private fun showToast(message: String) {
        // Aqui você pode usar um Toast para mostrar a mensagem de erro
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}