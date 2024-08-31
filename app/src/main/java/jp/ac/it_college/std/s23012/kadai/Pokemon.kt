data class Pokemon(
    val id: Int, // id は Int 型
    val name: String,
    val types: List<String>
)

data class Type(
    val type: TypeInfo, // type は TypeInfo 型
    val name: String
)

data class TypeInfo(
    val name: String
)

// インスタンス作成時に修正
