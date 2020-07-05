package asserts.junit

import common.Asserts
import common.genericGetType
import org.junit.jupiter.api.Assertions.*

class JUnitAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        assertEquals(expected, actual)
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        assertNotEquals(unexpected, actual)
    }

    override fun substringAssert(haystack: String, needle: String) {
        assertLinesMatch(listOf(".*$needle.*"), listOf(haystack))
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        assertFalse(haystack.contains(needle))
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        assertIterableEquals(expected, actual)
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        assertNotEquals(unexpected, actual)
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        assertEquals(expected, actual)
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        assertNotEquals(unexpected, actual)
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        val exception = assertThrows(expectedClass) { //can also be assertThrows<T>{...} if inlined
            block()
        }

        assertEquals(expectedMessage, exception.message)
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        assertTrue(collection.contains(item))
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        assertFalse(collection.contains(item))
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        assertTrue(collection.containsAll(items))
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        assertFalse(
            collection.any { items.contains(it) }
        )
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        assertEquals(expected, actual)
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        assertNotEquals(unexpected, actual)
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        assertArrayEquals(expected, actual)
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        assertFalse(unexpected.contentEquals(actual))
    }

    override fun nativeArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        assertArrayEquals(expected, actual)
    }

    override fun nativeArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        assertFalse(unexpected.contentEquals(actual))
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        assertEquals(expected, actual) //no asserts for that
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        assertNotEquals(unexpected, actual) //no asserts for that
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        assertEquals(expected, actual)
    }

    override fun genericDerivingTest() {
        assertEquals(genericGetType("str"), 2)
    }

}