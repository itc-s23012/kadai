package jp.ac.it_college.std.s23012.kadai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

private val client = OkHttpClient()

suspend fun fetchPokemonType(pokemonId: String): String? {
    return withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/$pokemonId")
            .build()

        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val responseBody = response.body?.string() ?: return@withContext null
            val jsonObject = JSONObject(responseBody)
            val types = jsonObject.getJSONArray("types")

            // 複数のタイプを取得し、結合して返す
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
fun translateTypeToJapanese(type: String): String {
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
