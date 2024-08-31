package jp.ac.it_college.std.s23012.kadai

import Pokemon
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PokemonListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pokemonListAdapter: PokemonListAdapter
    private val pokemonList = mutableListOf<Pokemon>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        pokemonListAdapter = PokemonListAdapter(pokemonList)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = pokemonListAdapter

        // Sample data, replace with real data
        pokemonListAdapter.notifyDataSetChanged()
    }
}
