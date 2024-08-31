package jp.ac.it_college.std.s23012.kadai

import Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface PokeApiService {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>
}