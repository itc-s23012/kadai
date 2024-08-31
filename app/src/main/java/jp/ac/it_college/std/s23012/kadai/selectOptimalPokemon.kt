fun selectOptimalPokemon(opponentTypes: List<String>): Pokemon? {
    // 仮のポケモンリストを作成（ここではサンプルデータとしてポケモンを生成しています）
    val allPokemons = (1..100).map { id -> Pokemon(id, "Pokemon$id", listOf("Type${id % 10}")) }

    // ポケモンの選択ロジック
    // ここでは、対戦相手のポケモンタイプに最も対応できるポケモンを選ぶ簡単な例です
    return allPokemons.maxByOrNull { pokemon ->
        // 簡単な基準としてポケモンのタイプが対戦相手のタイプと一致する回数をカウント
        opponentTypes.count { type -> type in pokemon.types }
    }
}
