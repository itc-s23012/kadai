package jp.ac.it_college.std.s23012.kadai

import Pokemon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonListAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = pokemonList.size

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pokemonName: TextView = itemView.findViewById(R.id.pokemonName)
        private val pokemonType: TextView = itemView.findViewById(R.id.pokemonType)

        fun bind(pokemon: Pokemon) {
            pokemonName.text = pokemon.name
            pokemonType.text = pokemon.types.joinToString(", ")
        }
    }
}
