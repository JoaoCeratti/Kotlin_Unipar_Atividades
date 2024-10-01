
package com.example.verdejar

import PlantaAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taffebank.Planta
import com.example.taffebank.R

class MainActivity : AppCompatActivity() {

    private lateinit var plantaAdapter: PlantaAdapter
    private lateinit var plantas: MutableList<Planta>

    private lateinit var NomePlantaInsert: EditText
    private lateinit var DataPlantioInsert: EditText
    private lateinit var NivelPlantaTextView: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NomePlantaInsert = findViewById(R.id.AddPlanta)
        DataPlantioInsert = findViewById(R.id.DataPlanta)
        NivelPlantaTextView = findViewById(R.id.NivelPlanta)

        val btnAdd: Button = findViewById(R.id.BtnAdd)

        plantas = mutableListOf()
        plantaAdapter = PlantaAdapter(plantas)


        btnAdd.setOnClickListener {
            val nome = NomePlantaInsert.text.toString()
            val data = DataPlantioInsert.text.toString()
            val nivel = NivelPlantaTextView.text.toString()

            val novaPlanta = Planta(nome, data, nivel)
            plantaAdapter.addPlanta(novaPlanta)
        }
    }
}