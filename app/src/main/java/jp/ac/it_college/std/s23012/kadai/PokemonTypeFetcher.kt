package jp.ac.it_college.std.s23012.kadai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

private val client = OkHttpClient()

suspend fun fetchPokemonTypeFromApi(pokemonId: String): String? {
    return withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/$pokemonId")
            .build()

        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val responseBody = response.body?.string() ?: return@withContext null
            val jsonObject = JSONObject(responseBody)
            val types = jsonObject.getJSONArray("types")
            return@withContext types.getJSONObject(0).getJSONObject("type").getString("name")
        }
        return@withContext null
    }
}
