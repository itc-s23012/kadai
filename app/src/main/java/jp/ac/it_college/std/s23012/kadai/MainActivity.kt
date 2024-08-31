package jp.ac.it_college.std.s23012.kadai

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var client: OkHttpClient
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        client = OkHttpClient()

        val pokemonIdInputs = listOf(
            findViewById<EditText>(R.id.pokemonId1),
            findViewById<EditText>(R.id.pokemonId2),
            findViewById<EditText>(R.id.pokemonId3),
            findViewById<EditText>(R.id.pokemonId4),
            findViewById<EditText>(R.id.pokemonId5)
        )

        val selectButton = findViewById<Button>(R.id.selectPokemonButton)
        val pokemonListLayout = findViewById<LinearLayout>(R.id.pokemonList)

        selectButton.setOnClickListener {
            pokemonListLayout.removeAllViews()
            pokemonIdInputs.forEach { editText ->
                val pokemonId = editText.text.toString()
                if (pokemonId.isNotEmpty()) {
                    fetchPokemon(pokemonId.toInt(), pokemonListLayout)
                }
            }
        }
    }

    private fun fetchPokemon(id: Int, container: LinearLayout) {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/$id")
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: java.io.IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (!response.isSuccessful) throw java.io.IOException("Unexpected code $response")

                val jsonData = response.body?.string()
                val jsonObject = JSONObject(jsonData)
                val name = jsonObject.getString("name")
                val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

                coroutineScope.launch {
                    val pokemonType = fetchPokemonType(id.toString())

                    runOnUiThread {
                        val pokemonView = layoutInflater.inflate(R.layout.pokemon_info, null)
                        val pokemonName = pokemonView.findViewById<TextView>(R.id.pokemonName)
                        val pokemonTypeView = pokemonView.findViewById<TextView>(R.id.pokemonType)
                        val pokemonImage = pokemonView.findViewById<ImageView>(R.id.pokemonImage)
                        val pokemonLink = pokemonView.findViewById<TextView>(R.id.pokemonLink)

                        pokemonName.text = name
                        pokemonTypeView.text = "Type: $pokemonType"
                        Picasso.get().load(imageUrl).into(pokemonImage)
                        pokemonLink.setOnClickListener {
                            // Open Pokemon URL
                        }

                        container.addView(pokemonView)
                    }
                }
            }
        })
    }

    private suspend fun fetchPokemonType(pokemonId: String): String? {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/$pokemonId")
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val responseBody = response.body?.string() ?: return@withContext null
                val jsonObject = JSONObject(responseBody)
                val types = jsonObject.getJSONArray("types")

                val typeList = mutableListOf<String>()
                for (i in 0 until types.length()) {
                    val typeName = types.getJSONObject(i).getJSONObject("type").getString("name")
                    typeList.add(translateTypeToJapanese(typeName)) // 日本語に変換
                }

                return@withContext typeList.joinToString(separator = ", ")
            }
            return@withContext null
        }
    }

    // 英語のタイプ名を日本語に変換する関数
    private fun translateTypeToJapanese(type: String): String {
        return when (type) {
            "normal" -> "ノーマル"
            "fire" -> "ほのお"
            "water" -> "みず"
            "electric" -> "でんき"
            "grass" -> "くさ"
            "ice" -> "こおり"
            "fighting" -> "かくとう"
            "poison" -> "どく"
            "ground" -> "じめん"
            "flying" -> "ひこう"
            "psychic" -> "エスパー"
            "bug" -> "むし"
            "rock" -> "いわ"
            "ghost" -> "ゴースト"
            "dragon" -> "ドラゴン"
            "dark" -> "あく"
            "steel" -> "はがね"
            "fairy" -> "フェアリー"
            else -> type // デフォルトでは英語のまま返す
        }
    }
}
