package com.example.truco

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private var pontoJogador1 = 0
    private var pontoJogador2 = 0
    private var pontosJogador1 = 0
    private var pontosJogador2 = 0

    private lateinit var tvPontoJogador1: TextView
    private lateinit var tvPontoJogador2: TextView
    private lateinit var tvPontosJogador1: TextView
    private lateinit var tvPontosJogador2: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPontoJogador1 = findViewById(R.id.tvPontoJogador1)
        tvPontoJogador2 = findViewById(R.id.tvPontoJogador2)

        val btnPontoJogador1: Button = findViewById(R.id.btnPontoJogador1)
        val btnPontoJogador2: Button = findViewById(R.id.btnPontoJogador2)
        val btnPontosJogador1: Button = findViewById(R.id.btnPontosJogador1)
        val btnPontosJogador2: Button = findViewById(R.id.btnPontosJogador2)
        val btnZerar: Button = findViewById(R.id.btnZerar)

        btnPontoJogador1.setOnClickListener {
            adicionarPonto(1)
        }

        btnPontoJogador2.setOnClickListener {
            adicionarPonto(2)
        }

        btnPontosJogador1.setOnClickListener {
            adicionar3Ponto(1)
        }

        btnPontosJogador2.setOnClickListener {
            adicionar3Ponto(2)
        }





        btnZerar.setOnClickListener {
            zerarPontos()
        }
    }
        private fun adicionarPonto(jogador: Int){
            if (jogador == 1){
                pontoJogador1++
                tvPontoJogador1.text = "Jogador 1: $pontoJogador1"
                verificarpontos()
            } else {
                pontoJogador2++
                tvPontoJogador2.text = "Jogador 2: $pontoJogador2"
                verificarpontos()
            }
        }

    private fun adicionar3Ponto(jogador: Int){
        if (jogador == 1){
            pontoJogador1 += 3
            tvPontoJogador1.text = "Jogador 1: $pontoJogador1"
            verificarpontos()
        } else {
            pontoJogador2 += 3
            tvPontoJogador2.text = "Jogador 2: $pontoJogador2"
            verificarpontos()
        }
    }

    private fun verificarpontos() {
        if (pontoJogador1 >=12 || pontoJogador2 >=12) {
            zerarPontos()
        }
    }

        private fun zerarPontos() {
            pontoJogador1 = 0
            pontoJogador2 = 0
            tvPontoJogador1.text = "Jogador 1: $pontoJogador1"
            tvPontoJogador2.text = "Jogador 2: $pontoJogador2"
        }

}