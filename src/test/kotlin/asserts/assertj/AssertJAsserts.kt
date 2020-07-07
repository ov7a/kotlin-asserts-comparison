package asserts.assertj

import common.Asserts
import common.genericGetType
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class AssertJAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        assertThat(actual).isEqualTo(expected)
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        assertThat(actual).isNotEqualTo(unexpected)
    }

    override fun substringAssert(haystack: String, needle: String) {
        assertThat(haystack).contains(needle)
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        assertThat(haystack).doesNotContain(needle)
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        assertThat(actual).isEqualTo(expected)
    }
    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        assertThat(actual).isNotEqualTo(unexpected)
    }
    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        assertThat(actual).isEqualTo(expected)
    }
    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        assertThat(actual).isNotEqualTo(unexpected)
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        assertThatThrownBy {
            block()
        }
            .isInstanceOf(expectedClass)
            .hasMessageContaining(expectedMessage)
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        assertThat(collection).contains(item)
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        assertThat(collection).doesNotContain(item)
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        assertThat(collection).containsAll(items)
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        assertThat(collection).doesNotContainAnyElementsOf(items)
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        assertThat(actual)
            .usingRecursiveComparison()
            .isEqualTo(expected)
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        assertThat(actual)
            .usingRecursiveComparison()
            .isNotEqualTo(unexpected)
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        assertThat(actual).isEqualTo(expected)
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        assertThat(actual).isNotEqualTo(unexpected)
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        assertThat(actual).isEqualTo(expected)
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        assertThat(actual).isNotEqualTo(unexpected)
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        assertThat(actual)
            .usingRecursiveComparison()
            .isEqualTo(expected)
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        assertThat(actual)
            .usingRecursiveComparison()
            .isNotEqualTo(unexpected)
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        assertThat(actual).isEqualTo(expected)
    }

    override fun genericDerivingTest(){
        assertThat(genericGetType<String>("str")).isEqualTo(2)
    }

}