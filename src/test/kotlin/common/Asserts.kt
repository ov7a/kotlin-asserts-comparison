package common

interface Asserts {
    fun <T> simpleAssert(actual: T, expected: T)
    fun <T> simpleAssertNegation(actual: T, unexpected: T)

    fun substringAssert(haystack: String, needle: String)
    fun substringAssertNegation(haystack: String, needle: String)

    fun <T: Throwable> exceptionAssert(expectedClass: Class<T>, expectedMessage: String, block: () -> Unit)

    fun <T> listEqualityAssert(actual: List<T>, expected: List<T>)
    fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>)

    fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>)
    fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>)

    fun <T> itemPresenceAssert(collection: Collection<T>, item: T)
    fun <T> itemAbsenceAssert(collection: Collection<T>, item: T)
    fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>)
    fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>)

    fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>)
    fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>)

    fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>)
    fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>)

    fun nativeArrayEqualityAssert(actual: ByteArray, expected: ByteArray)
    fun nativeArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray)

    fun <T> structuralAssert(actual: T, expected: T)
    fun <T> structuralAssertNegation(actual: T, unexpected: T)

    fun <A, E> untypedAssert(actual: A, expected: E)

    fun genericDerivingTest()
}