package jp.ac.it_college.std.s23012.kadai

object TypeEffectiveness {
    private val effectiveness = mapOf(
        // Attacker type -> (Defender type -> Effectiveness)
        "normal" to mapOf(
            "rock" to 0.5, "ghost" to 0.0, "steel" to 0.5, "fire" to 1.0, "water" to 1.0,
            "grass" to 1.0, "electric" to 1.0, "psychic" to 1.0, "ice" to 1.0, "dragon" to 1.0,
            "dark" to 1.0, "fairy" to 1.0
        ),
        "fire" to mapOf(
            "grass" to 2.0, "fire" to 1.0, "water" to 0.5, "electric" to 1.0, "ice" to 1.0,
            "bug" to 2.0, "rock" to 0.5, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "water" to mapOf(
            "grass" to 0.5, "fire" to 2.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "electric" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 2.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "grass" to mapOf(
            "grass" to 1.0, "fire" to 0.5, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 0.5, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "ice" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 2.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "fighting" to mapOf(
            "normal" to 1.0, "rock" to 2.0, "ghost" to 1.0, "steel" to 1.0, "fire" to 1.0,
            "water" to 1.0, "grass" to 1.0, "electric" to 1.0, "psychic" to 1.0, "ice" to 1.0,
            "dragon" to 1.0, "dark" to 2.0, "fairy" to 1.0
        ),
        "poison" to mapOf(
            "grass" to 2.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "ground" to mapOf(
            "grass" to 0.5, "fire" to 1.0, "water" to 1.0, "electric" to 2.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "flying" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 2.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "psychic" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 0.5, "fairy" to 1.0
        ),
        "bug" to mapOf(
            "grass" to 1.0, "fire" to 0.5, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 2.0, "fairy" to 0.5
        ),
        "rock" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "ghost" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 2.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        ),
        "dragon" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 2.0, "dark" to 1.0, "fairy" to 0.5
        ),
        "dark" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 0.5
        ),
        "fairy" to mapOf(
            "grass" to 1.0, "fire" to 1.0, "water" to 1.0, "electric" to 1.0, "ice" to 1.0,
            "bug" to 1.0, "rock" to 1.0, "ghost" to 1.0, "dragon" to 1.0, "dark" to 1.0, "fairy" to 1.0
        )
    )

    fun getEffectiveness(attackerType: String, defenderType: String): Double {
        return effectiveness[attackerType]?.get(defenderType) ?: 1.0
    }
}
