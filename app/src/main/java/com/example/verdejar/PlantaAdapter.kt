import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taffebank.Planta
import com.example.taffebank.R

class PlantaAdapter(private val plantas: MutableList<Planta>) : RecyclerView.Adapter<PlantaAdapter.PlantaViewHolder>() {

    class PlantaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nomeTextView: TextView = view.findViewById(R.id.AddPlanta)
        val dataTextView: TextView = view.findViewById(R.id.DataPlanta)
        val nivelTextView: TextView = view.findViewById(R.id.NivelPlanta)
    }





    override fun onBindViewHolder(holder: PlantaViewHolder, position: Int) {
        val planta = plantas[position]
        holder.nomeTextView.text = planta.nome
        holder.dataTextView.text = planta.dataPlantio
        holder.nivelTextView.text = planta.nivelCuidado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantaViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return plantas.size
    }

    fun addPlanta(planta: Planta) {
        plantas.add(planta)
        notifyItemInserted(plantas.size - 1)  // Atualiza o RecyclerView
    }
}