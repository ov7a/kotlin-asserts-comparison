package common

internal object TestData {
    val fizzMap = mapOf(1 to "1", 2 to "2", 3 to "fizz")
    val fizzBuzzMap = mapOf(1 to "1", 2 to "2", 3 to "fizz", 4 to "4", 5 to "buzz")
    val fizzBuzzMapCopy = mapOf(1 to "1", 2 to "2", 3 to "fizz", 4 to "4", 5 to "buzz")
    val fazzBuzzMap = mapOf(1 to "1", 2 to "2", 3 to "fazz", 4 to "4", 5 to "buzz")

    val complexMap = mapOf(
        "array" to arrayOf(1, 2),
        "list" to listOf(1, 2, 3),
        "int" to 2,
        "string" to "sss",
        "null" to null
    )

    //Copy-paste to avoid compare by reference
    val complexMapCopy = mapOf(
        "array" to arrayOf(1, 2),
        "list" to listOf(1, 2, 3),
        "int" to 2,
        "string" to "sss",
        "null" to null
    )

    val complexMapUnexpected = mapOf(
        "list" to listOf(1, 2, 3),
        "int" to 2,
        "string" to "sss",
        "null" to null,
        "unexpectedKey" to "some_value"
    )

    val complexStructure = mapOf(
        "array" to arrayOf(1, 2),
        "list" to listOf(1, 2, 3),
        "bytearray" to byteArrayOf(1, 2, 3, 4),
        "int" to 2,
        "string" to "sss",
        "map" to mapOf(
            "2" to 2,
            "lissst" to listOf("1", 2, "5", null, mapOf("1" to byteArrayOf(1, 2, 3, 5)), setOf(listOf(1, 2, 3))),
            "bytearray" to byteArrayOf(1, 2, 3, 5)
        ),
        "null" to null
    )

    //Copy-paste to avoid compare by reference
    val complexStructureCopy = mapOf(
        "array" to arrayOf(1, 2),
        "list" to listOf(1, 2, 3),
        "bytearray" to byteArrayOf(1, 2, 3, 4),
        "int" to 2,
        "string" to "sss",
        "map" to mapOf(
            "2" to 2,
            "lissst" to listOf("1", 2, "5", null, mapOf("1" to byteArrayOf(1, 2, 3, 5)), setOf(listOf(1, 2, 3))),
            "bytearray" to byteArrayOf(1, 2, 3, 5)
        ),
        "null" to null
    )

    val complexStructureUnexpected = mapOf(
        "array" to arrayOf(1, 2),
        "list" to listOf(1, 2, 3),
        "bytearray" to byteArrayOf(1, 2, 3, 4, 5),
        "int" to 2,
        "string" to "sss",
        "map" to mapOf(
            "2" to 2,
            "4" to "3",
            "lissst" to listOf("1", 2, "5", null, mapOf("1" to byteArrayOf(1, 2, 3, 5)), setOf(listOf(1, 2, 3, 3))),
            "bytearray" to byteArrayOf(1, 2, 3, 5)
        ),
        "null" to null
    )
}

@Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
fun <T> genericGetType(desiredType: String): T = when(desiredType) {
    "str" -> "str"
    "int" -> 1
    else -> "unknown"
} as T