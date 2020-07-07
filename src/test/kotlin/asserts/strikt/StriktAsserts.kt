package asserts.strikt

import common.Asserts
import common.genericGetType
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.*

class StriktAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        expectThat(actual).isEqualTo(expected)
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        expectThat(actual).isNotEqualTo(unexpected)
    }

    override fun substringAssert(haystack: String, needle: String) {
        expectThat(haystack).contains(needle)
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        expectThat(haystack).not().contains(needle)
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        expectThat(actual).isEqualTo(expected)
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        expectThat(actual).isNotEqualTo(unexpected)
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        expectThat(actual).isEqualTo(expected)
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        expectThat(actual).isNotEqualTo(unexpected)
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        expectThrows<RuntimeException> {  //doesn't have expectThrows with explicit class
            block()
        }
            .message
            .isEqualTo(expectedMessage)
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        expectThat(collection).contains(item)
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        expectThat(collection).doesNotContain(item)
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        expectThat(collection).contains(items)
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        expectThat(collection).doesNotContain(items)
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        expectThat(actual).isEqualTo(expected)
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        expectThat(actual).isNotEqualTo(unexpected)
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        expectThat(actual as Array<out T>).contentEquals(expected)
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        expectThat(actual as Array<out T>).not().contentEquals(unexpected)
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        expectThat(actual).contentEquals(expected)
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        expectThat(actual).not().contentEquals(unexpected)
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        expectThat(actual).isEqualTo(expected)
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        expectThat(actual).isNotEqualTo(unexpected)
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        expectThat(actual as E).isEqualTo(expected)
    }

    override fun genericDerivingTest() {
        expectThat(genericGetType<Int>("str")).isEqualTo(2)
    }

}