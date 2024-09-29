package com.example.filme

import Filme
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val filmes = listOf(
            Filme("Rapidos e Raivosos", "Ação", 2022),
            Filme("Marquinhos lightning", "corrida", 2021),
            Filme("o pega vai bixo", "Comédia", 2023)
        )

        recyclerView.adapter = FilmeAdapter(filmes)
    }
}