package asserts.kotest

import common.Asserts
import common.genericGetType
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.*
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotContain
import io.kotest.matchers.throwable.shouldHaveMessage
import java.lang.RuntimeException

class KotestAsserts : Asserts {
    override fun <T> simpleAssert(actual: T, expected: T) {
        actual shouldBe expected
    }

    override fun <T> simpleAssertNegation(actual: T, unexpected: T) {
        actual shouldNotBe unexpected
    }

    override fun substringAssert(haystack: String, needle: String) {
        haystack shouldContain needle
    }

    override fun substringAssertNegation(haystack: String, needle: String) {
        haystack shouldNotContain needle
    }

    override fun <T> listEqualityAssert(actual: List<T>, expected: List<T>) {
        actual shouldBe expected
    }

    override fun <T> listEqualityAssertNegation(actual: List<T>, unexpected: List<T>) {
        actual shouldNotBe unexpected
    }

    override fun <T> setEqualityAssert(actual: Set<T>, expected: Set<T>) {
        actual shouldBe expected
    }

    override fun <T> setEqualityAssertNegation(actual: Set<T>, unexpected: Set<T>) {
        actual shouldNotBe unexpected
    }

    override fun <T : Throwable> exceptionAssert(
        expectedClass: Class<T>,
        expectedMessage: String,
        block: () -> Unit
    ) {
        val exception = shouldThrow<RuntimeException> { //doesn't have shouldThrow with explicit class
            block()
        }

        exception shouldHaveMessage expectedMessage
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
        collection shouldNotContainAnyOf items
    }

    override fun <K, V> mapEqualityAssert(actual: Map<K, V>, expected: Map<K, V>) {
        actual shouldBe expected
    }

    override fun <K, V> mapEqualityAssertNegation(actual: Map<K, V>, unexpected: Map<K, V>) {
        actual shouldNotBe unexpected
    }

    override fun <T> arrayEqualityAssert(actual: Array<T>, expected: Array<T>) {
        actual shouldBe expected
    }

    override fun <T> arrayEqualityAssertNegation(actual: Array<T>, unexpected: Array<T>) {
        actual shouldNotBe unexpected
    }

    override fun nativeArrayEqualityAssert(actual: ByteArray, expected: ByteArray) {
        actual shouldBe expected
    }

    override fun nativeArrayEqualityAssertNegation(actual: ByteArray, unexpected: ByteArray) {
        actual shouldNotBe unexpected
    }

    override fun <T> structuralAssert(actual: T, expected: T) {
        actual shouldBe expected
    }

    override fun <T> structuralAssertNegation(actual: T, unexpected: T) {
        actual shouldNotBe unexpected
    }

    override fun <A, E> untypedAssert(actual: A, expected: E) {
        actual shouldBe expected
    }

    override fun genericDerivingTest() {
        genericGetType<String>("str") shouldBe 2
    }

}