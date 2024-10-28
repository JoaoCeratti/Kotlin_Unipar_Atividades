package com.example.ex1.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ex1.R
import com.example.ex1.entidade.Item

class ItemAdapter(
    private val itemList: List<Item>,
    private val deleteItemCallback: (Item) -> Unit,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemList.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewItemDescription: TextView = itemView.findViewById(R.id.textViewItemDescription)
        private val textViewItemQuantity: TextView = itemView.findViewById(R.id.textViewItemQuantity)
        private val buttonDelete: Button = itemView.findViewById(R.id.buttonDelete)

        fun bind(item: Item) {
            textViewItemDescription.text = item.description
            textViewItemQuantity.text = "Quantidade item : ${item.quantity}"

            buttonDelete.setOnClickListener {
                deleteItemCallback(item)
            }

        }
    }
}