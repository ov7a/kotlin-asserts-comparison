package asserts.kotlin.test

import common.Asserts
import common.genericGetType
import kotlin.test.*

class KotlinTestAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        assertEquals(expected, actual)
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        assertNotEquals(unexpected, actual)
    }

    override fun substringAssert(haystack: String, needle: String) {
        assertTrue(haystack.contains(needle))
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        assertFalse(haystack.contains(needle))
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        assertEquals(expected, actual)
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
        val exception =
            assertFailsWith(expectedClass.kotlin) { //can also be assertFailsWith<T>{...} if inlined
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
        assertTrue(expected.contentEquals(actual))
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        assertFalse(unexpected.contentEquals(actual))
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        assertTrue(expected.contentEquals(actual))
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        assertFalse(unexpected.contentEquals(actual))
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        assertEquals(expected, actual) //no asserts for that
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        assertNotEquals(unexpected, actual) //no asserts for that
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        assertEquals(expected as A, actual)
    }

    override fun genericDerivingTest() {
        assertEquals(genericGetType("str"), "2")
    }
}