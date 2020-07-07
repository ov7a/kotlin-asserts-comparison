package asserts.atrium

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import common.Asserts
import common.genericGetType

class AtriumAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        expect(actual).toBe(expected)
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        expect(actual).notToBe(unexpected)
    }

    override fun substringAssert(haystack: String, needle: String) {
        expect(haystack).contains(needle)
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        expect(haystack).containsNot(needle)
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        expect(actual).toBe(expected)
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        expect(actual).notToBe(unexpected)
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        expect(actual).toBe(expected)
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        expect(actual).notToBe(unexpected)
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        expect {
            block()
        }
            .toThrow<RuntimeException>() //no assert for explicit class
            .message
            .toBe(expectedMessage)
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        expect(collection).contains(item)
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        expect(collection).containsNot(item)
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        expect(collection).containsElementsOf(items as Set<Int>) //cant derive generic type here
        //or expect(collection).contains(1,2,3)
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        expect(collection).containsNot.elementsOf(items as Set<Int>)
        //or expect(collection).containsNot(1,2,3)
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        expect(actual).toBe(expected)
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        expect(actual).notToBe(unexpected)
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        expect(actual).toBe(expected) //no arrays support, see https://github.com/robstoll/atrium/issues/459
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        expect(actual).notToBe(unexpected)
    }

    override fun nativeArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        expect(actual).toBe(expected) //no arrays support, see https://github.com/robstoll/atrium/issues/459
    }

    override fun nativeArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        expect(actual).notToBe(unexpected)
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        expect(actual).toBe(expected)
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        expect(actual).notToBe(unexpected)
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        expect(actual as E).toBe(expected)
    }

    override fun genericDerivingTest() {
        expect(genericGetType<Int>("str")).toBe(2)
    }

}