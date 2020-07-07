package asserts.hamcrest

import common.Asserts
import common.genericGetType
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertThrows

class HamcrestAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        assertThat(actual, not(unexpected))
    }

    override fun substringAssert(haystack: String, needle: String) {
        assertThat(haystack, containsString(needle))
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        assertThat(haystack, not(containsString(needle)))
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        assertThat(actual, not(unexpected))
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        assertThat(actual, not(unexpected))
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        val exception = assertThrows(expectedClass) { //no assert for exceptions
            block()
        }

        assertThat(exception.message, equalTo(expectedMessage))
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        assertThat(collection, hasItem(item))
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        assertThat(collection, not(hasItem(item)))
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        assertThat(collection, allOf(items.map { hasItem(it) }))
        //can be written as assertThat(collection, hasItems(1, 2, 3)), but doesn't support non-array collections.
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        assertThat(collection, not(anyOf(items.map { hasItem(it) })))
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        assertThat(actual, not(equalTo(unexpected)))
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        assertThat(actual, not(unexpected))
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        assertThat(actual, equalTo(expected))
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        assertThat(actual, not(unexpected))
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        assertThat(actual, not(equalTo(unexpected)))
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        assertThat(actual as E, equalTo(expected))
    }

    override fun genericDerivingTest() {
        assertThat(genericGetType("str"), equalTo(2))
    }

}