package jp.ac.it_college.std.s23012.kadai

import Pokemon
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import selectOptimalPokemon

suspend fun formParty(opponentPokemonIds: List<String>): List<Pokemon> = coroutineScope {
    // すべてのポケモンタイプを非同期に取得
    val opponentTypesDeferred = opponentPokemonIds.map { id ->
        async {
            fetchPokemonType(id)
        }
    }

    val opponentTypes = opponentTypesDeferred.awaitAll().filterNotNull()

    val party = mutableListOf<Pokemon>()
    val usedPokemonIds = mutableSetOf<Int>() // 重複を防ぐためのセット

    // 最大5体のポケモンでパーティーを形成
    repeat(5) {
        val bestPokemon = selectOptimalPokemon(opponentTypes)
        if (bestPokemon != null && !usedPokemonIds.contains(bestPokemon.id)) {
            party.add(bestPokemon)
            usedPokemonIds.add(bestPokemon.id)
        }
    }

    return@coroutineScope party
}
