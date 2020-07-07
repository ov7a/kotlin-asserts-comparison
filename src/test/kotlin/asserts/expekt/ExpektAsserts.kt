package asserts.expekt

import com.winterbe.expekt.should
import common.Asserts
import common.genericGetType
import org.junit.jupiter.api.Assertions.assertThrows

class ExpektAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        actual.should.equal(expected)
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        actual.should.not.equal(unexpected)
    }

    override fun substringAssert(haystack: String, needle: String) {
        haystack.should.contain(needle)
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        haystack.should.not.contain(needle)
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        actual.should.equal(expected)
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        actual.should.not.equal(unexpected)
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        actual.should.equal(expected)
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        actual.should.not.equal(unexpected)
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        val exception = assertThrows(expectedClass) { //no exceptions support
            block()
        }

        exception.message.should.equal(expectedMessage)
    }

    override fun <T> itemPresenceAssert(collection: Collection<T>, item: T) {
        collection.should.contain(item)
    }

    override fun <T> itemAbsenceAssert(collection: Collection<T>, item: T) {
        collection.should.not.contain(item)
    }

    override fun <T> multipleItemPresenceAssert(collection: Collection<T>, items: Set<T>) {
        val itemsArray = (items as Set<Int>).toTypedArray()
        (collection as Collection<Int>).should.contain.all.elements(*itemsArray)
        //collection.should.have.elements(1,2,3)
    }

    override fun <T> multipleItemAbsenceAssert(collection: Collection<T>, items: Set<T>) {
        val itemsArray = (items as Set<Int>).toTypedArray()
        (collection as Collection<Int>).should.not.contain.any.elements(*itemsArray)
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        actual.should.equal(expected)
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        actual.should.not.equal(unexpected)
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        actual.should.equal(expected)
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        actual.should.not.equal(unexpected)
    }

    override fun primitiveArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        actual.should.equal(expected)
    }

    override fun primitiveArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        actual.should.not.equal(unexpected)
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        actual.should.equal(expected)
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        actual.should.not.equal(unexpected)
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        (actual as E).should.equal(expected)
    }

    override fun genericDerivingTest() {
        genericGetType<Int>("str").should.equal(2)
    }

}