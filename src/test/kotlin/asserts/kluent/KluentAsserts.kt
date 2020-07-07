package asserts.kluent

import common.Asserts
import common.genericGetType
import org.amshove.kluent.*

class KluentAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        actual shouldBeEqualTo expected
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun substringAssert(haystack: String, needle: String) {
        haystack shouldContain needle
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        haystack shouldNotContain needle
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        actual shouldBeEqualTo expected
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        actual shouldBeEqualTo expected
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        invoking { block() } shouldThrow expectedClass.kotlin withMessage expectedMessage
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        collection shouldContain item
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        collection shouldNotContain item
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        collection shouldContainAll items
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        collection shouldContainNone items
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        actual shouldBeEqualTo expected
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        actual shouldBeEqualTo expected
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        actual shouldBeEqualTo expected
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        actual shouldBeEqualTo expected
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        actual shouldNotBeEqualTo unexpected
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        actual shouldBeEqualTo expected
    }

    override fun genericDerivingTest() {
        genericGetType<String>("str") shouldBeEqualTo 2
    }

}