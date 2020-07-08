package asserts.hamkrest

import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.assertThat
import common.Asserts
import common.genericGetType

class HamkrestAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun substringAssert(haystack: String, needle: String) {
        assertThat(haystack, containsSubstring(needle))
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        assertThat(haystack, !(containsSubstring(needle)))
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        assertThat({
            block()
        }, throws(has(RuntimeException::message, equalTo(expectedMessage))))
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        assertThat(collection, hasElement(item))
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        assertThat(collection, !hasElement(item))
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        assertThat(collection, allOf(items.map { hasElement(it) })) //no containAll
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        assertThat(collection, !anyOf(items.map { hasElement(it) }))
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        assertThat(actual, equalTo(expected))
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        assertThat(actual, equalTo(expected))
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        assertThat(actual, !equalTo(unexpected))
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        assertThat(actual as E, equalTo(expected))
    }

    override fun genericDerivingTest() {
        assertThat(genericGetType("str"), equalTo(2))
    }

}