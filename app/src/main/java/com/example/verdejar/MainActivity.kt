
package com.example.taffebank

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.verdejar.R

class MainActivity : AppCompatActivity() {

    private var saldoAtual: Double = 0.0
    private lateinit var NivelPlantaTextView: EditText
    private lateinit var NomePlantaInsert: EditText
    private lateinit var DataPlantioInsert: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NomePlantaInsert = findViewById(R.id.AddPlanta)
        DataPlantioInsert = findViewById(R.id.DataPlanta)
        NivelPlantaTextView = findViewById(R.id.NivelPlanta)

        val btnAdd: Button = findViewById(R.id.BtnAdd)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewPlanta)

        btnAdd.setOnClickListener {
            val Nome = NomePlantaInsert.text.toString()
            val data = DataPlantioInsert.text.toString()
            val Nivel = NivelPlantaTextView.text.toString()

        }
    }
}