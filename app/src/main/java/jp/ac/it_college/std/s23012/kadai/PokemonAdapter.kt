//package jp.ac.it_college.std.s23012.kadai
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.CheckBox
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//
//class PokemonAdapter(private val onPokemonSelected: (Pokemon) -> Unit) :
//    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
//
//    private var pokemonList: List<Pokemon> = listOf()
//
//    fun setPokemonList(newPokemonList: List<Pokemon>) {
//        pokemonList = newPokemonList
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_pokemon, parent, false)
//        return PokemonViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
//        val pokemon = pokemonList[position]
//        holder.bind(pokemon)
//    }
//
//    override fun getItemCount(): Int = pokemonList.size
//
//    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val nameTextView: TextView = itemView.findViewById(R.id.pokemonName)
//        private val typeTextView: TextView = itemView.findViewById(R.id.pokemonType)
//        private val imageView: ImageView = itemView.findViewById(R.id.pokemonImage)
//        private val checkBox: CheckBox = itemView.findViewById(R.id.pokemonCheckBox)
//
//        fun bind(pokemon: Pokemon) {
//            nameTextView.text = pokemon.name
//            typeTextView.text = pokemon.types.joinToString(", ")
//            Glide.with(itemView.context).load(pokemon.image).into(imageView)
//
//            checkBox.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    onPokemonSelected(pokemon)
//                } else {
//                    onPokemonSelected(pokemon)
//                }
//            }
//        }
//    }
//}
