package jp.ac.it_college.std.s23012.kadai

class Pokemon(val id: Int, val name: String, val type: String)

class PokemonSelector {

    private val allPokemon = listOf(
        Pokemon(1, "Bulbasaur", "Grass/Poison"),
        Pokemon(2, "Ivysaur", "Grass/Poison"),
        Pokemon(3, "Venusaur", "Grass/Poison"),
        Pokemon(4, "Charmander", "Fire"),
        Pokemon(5, "Charmeleon", "Fire"),
        Pokemon(6, "Charizard", "Fire/Flying"),
        Pokemon(7, "Squirtle", "Water"),
        Pokemon(8, "Wartortle", "Water"),
        Pokemon(9, "Blastoise", "Water"),
        Pokemon(10, "Caterpie", "Bug"),
        Pokemon(11, "Metapod", "Bug"),
        Pokemon(12, "Butterfree", "Bug/Flying"),
        Pokemon(13, "Weedle", "Bug/Poison"),
        Pokemon(14, "Kakuna", "Bug/Poison"),
        Pokemon(15, "Beedrill", "Bug/Poison"),
        Pokemon(16, "Pidgey", "Normal/Flying"),
        Pokemon(17, "Pidgeotto", "Normal/Flying"),
        Pokemon(18, "Pidgeot", "Normal/Flying"),
        Pokemon(19, "Rattata", "Normal"),
        Pokemon(20, "Raticate", "Normal"),
        Pokemon(21, "Spearow", "Normal/Flying"),
        Pokemon(22, "Fearow", "Normal/Flying"),
        Pokemon(23, "Ekans", "Poison"),
        Pokemon(24, "Arbok", "Poison"),
        Pokemon(25, "Pikachu", "Electric"),
        Pokemon(26, "Raichu", "Electric"),
        Pokemon(27, "Sandshrew", "Ground"),
        Pokemon(28, "Sandslash", "Ground"),
        Pokemon(29, "Nidoran♀", "Poison"),
        Pokemon(30, "Nidorina", "Poison"),
        Pokemon(31, "Nidoqueen", "Poison/Ground"),
        Pokemon(32, "Nidoran♂", "Poison"),
        Pokemon(33, "Nidorino", "Poison"),
        Pokemon(34, "Nidoking", "Poison/Ground"),
        Pokemon(35, "Clefairy", "Fairy"),
        Pokemon(36, "Clefable", "Fairy"),
        Pokemon(37, "Vulpix", "Fire"),
        Pokemon(38, "Ninetales", "Fire"),
        Pokemon(39, "Jigglypuff", "Normal/Fairy"),
        Pokemon(40, "Wigglytuff", "Normal/Fairy"),
        Pokemon(41, "Zubat", "Poison/Flying"),
        Pokemon(42, "Golbat", "Poison/Flying"),
        Pokemon(43, "Diglett", "Ground"),
        Pokemon(44, "Dugtrio", "Ground"),
        Pokemon(45, "Meowth", "Normal"),
        Pokemon(46, "Persian", "Normal"),
        Pokemon(47, "Psyduck", "Water"),
        Pokemon(48, "Golduck", "Water"),
        Pokemon(49, "Mankey", "Fighting"),
        Pokemon(50, "Primeape", "Fighting"),
        Pokemon(51, "Growlithe", "Fire"),
        Pokemon(52, "Arcanine", "Fire"),
        Pokemon(53, "Poliwag", "Water"),
        Pokemon(54, "Poliwhirl", "Water"),
        Pokemon(55, "Poliwrath", "Water/Fighting"),
        Pokemon(56, "Abra", "Psychic"),
        Pokemon(57, "Kadabra", "Psychic"),
        Pokemon(58, "Alakazam", "Psychic"),
        Pokemon(59, "Machop", "Fighting"),
        Pokemon(60, "Machoke", "Fighting"),
        Pokemon(61, "Machamp", "Fighting"),
        Pokemon(62, "Bellsprout", "Grass/Poison"),
        Pokemon(63, "Weepinbell", "Grass/Poison"),
        Pokemon(64, "Victreebel", "Grass/Poison"),
        Pokemon(65, "Tentacool", "Water/Poison"),
        Pokemon(66, "Tentacruel", "Water/Poison"),
        Pokemon(67, "Geodude", "Rock/Ground"),
        Pokemon(68, "Graveler", "Rock/Ground"),
        Pokemon(69, "Golem", "Rock/Ground"),
        Pokemon(70, "Ponyta", "Fire"),
        Pokemon(71, "Rapidash", "Fire"),
        Pokemon(72, "Slowpoke", "Water/Psychic"),
        Pokemon(73, "Slowbro", "Water/Psychic"),
        Pokemon(74, "Magnemite", "Electric/Steel"),
        Pokemon(75, "Magneton", "Electric/Steel"),
        Pokemon(76, "Magneton", "Electric/Steel"),
        Pokemon(77, "Farfetch'd", "Normal/Flying"),
        Pokemon(78, "Doduo", "Normal/Flying"),
        Pokemon(79, "Dodrio", "Normal/Flying"),
        Pokemon(80, "Seel", "Water"),
        Pokemon(81, "Dewgong", "Water/Ice"),
        Pokemon(82, "Grimer", "Poison"),
        Pokemon(83, "Muk", "Poison"),
        Pokemon(84, "Shellder", "Water"),
        Pokemon(85, "Cloyster", "Water/Ice"),
        Pokemon(86, "Gastly", "Ghost/Poison"),
        Pokemon(87, "Haunter", "Ghost/Poison"),
        Pokemon(88, "Gengar", "Ghost/Poison"),
        Pokemon(89, "Onix", "Rock/Ground"),
        Pokemon(90, "Steelix", "Steel/Ground"),
        Pokemon(91, "Drowzee", "Psychic"),
        Pokemon(92, "Hypno", "Psychic"),
        Pokemon(93, "Krabby", "Water"),
        Pokemon(94, "Kingler", "Water"),
        Pokemon(95, "Voltorb", "Electric"),
        Pokemon(96, "Electrode", "Electric"),
        Pokemon(97, "Exeggcute", "Grass/Psychic"),
        Pokemon(98, "Exeggutor", "Grass/Psychic"),
        Pokemon(99, "Lugia", "Psychic/Flying"),
        Pokemon(100, "Ho-oh", "Fire/Flying")
    )

    fun getPlayerPokemon(): Pokemon {
        val randomId = (1..100).random()
        return allPokemon.firstOrNull { it.id == randomId } ?: throw IllegalArgumentException("ポケモンが見つかりません")
    }
}

fun main() {
    val selector = PokemonSelector()

    // プレイヤーのポケモンを選択
    try {
        val playerPokemon = selector.getPlayerPokemon()
        println("選ばれたポケモン: ${playerPokemon.name}, タイプ: ${playerPokemon.type}")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
