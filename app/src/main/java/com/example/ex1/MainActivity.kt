package com.example.ex1

import Database.DatabaseHelper
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ex1.adapter.ItemAdapter
import com.example.ex1.entidade.Item

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var itemList: MutableList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val descricaoItem = findViewById<EditText>(R.id.editTextItemDescription)
        val quantidadeItem = findViewById<EditText>(R.id.editTextItemQuantity)
        val btnCadastrar = findViewById<Button>(R.id.buttonAddItem)
        val tabela = findViewById<RecyclerView>(R.id.recyclerViewItems)

        //Cria uma variavel para chamar o banco
        databaseHelper = DatabaseHelper(this)

        //Busca os dados de item do banco
        itemList = databaseHelper.getListItems().toMutableList()

        //Cria a ligaçao com o adapter passando a linha para ser carregada
        itemAdapter = ItemAdapter(itemList, { item -> deleteItem(item)})

        tabela.layoutManager = LinearLayoutManager(this)
        tabela.adapter = itemAdapter


        btnCadastrar.setOnClickListener{


            val descricaoTela = descricaoItem.text.toString()

            val quantidadeTela = quantidadeItem.text.toString().toIntOrNull() ?: 0


            if(descricaoTela.isNotEmpty() && quantidadeTela > 0){

                databaseHelper.saveItem(descricaoTela, quantidadeTela)

              updateItemList()

            }
        }

    }

    private fun updateItemList(){
        itemList.clear()
        itemList.addAll(databaseHelper.getListItems())
        itemAdapter.notifyDataSetChanged()
    }
    private fun deleteItem(item: Item){
        databaseHelper.deleteItem(item.id)
        updateItemList()
    }
}

