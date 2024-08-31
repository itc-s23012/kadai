//package jp.ac.it_college.std.s23012.kadai
//
//object PartyOptimizer {
//    fun optimizeParty(pokemonList: List<Pokemon>, opponentPokemon: List<Pokemon>): List<Pokemon> {
//        return pokemonList.sortedByDescending { pokemon ->
//            // ポケモンのタイプ相性に基づいてスコアを計算
//            opponentPokemon.sumByDouble { opponent ->
//                opponent.types.sumByDouble { type ->
//                    // 自分のポケモンが対戦相手のポケモンに対してどれだけ効果的かを評価
//                    pokemon.typeEffectiveness.getOrDefault(type, 1.0)
//                }
//            }
//        }.take(5) // 最も効果的な5体を選ぶ
//    }
//}