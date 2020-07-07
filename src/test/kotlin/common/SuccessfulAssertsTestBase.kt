package common

import common.TestData.complexMap
import common.TestData.complexMapCopy
import common.TestData.complexMapUnexpected
import common.TestData.complexStructure
import common.TestData.complexStructureCopy
import common.TestData.fazzBuzzMap
import common.TestData.fizzBuzzMap
import common.TestData.fizzBuzzMapCopy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(SuccessfulTestReportValidator::class)
internal abstract class SuccessfulAssertsTestBase(private val asserts: Asserts) : AssertsTestBase() {
    @Test
    override fun `simple assert should have descriptive message`() {
        asserts.simpleAssert(2, 2)
    }

    @Test
    override fun `simple assert can be negated`() {
        asserts.simpleAssertNegation(2, 1)
    }

    @Test
    override fun `string can be asserted for containing a substring`() {
        asserts.substringAssert("Quick lazy fox", "lazy")
        asserts.substringAssert("lazy", "lazy")
    }

    @Test
    override fun `string containing assert can be negated`() {
        asserts.substringAssertNegation("Quick lazy fox", "zaly")
        asserts.substringAssertNegation("Quick lazy fox", "productive")
        asserts.substringAssertNegation("Сase", "case")
    }

    @Test
    override fun `exception assert should look ok`() {
        asserts.exceptionAssert(RuntimeException::class.java, "SomeMessage") {
            throw RuntimeException("SomeMessage") 
        }
    }

    @Test
    override fun `list asserts should give detailed information`() {
        asserts.listEqualityAssert(listOf(1, 2, 3), listOf(1, 2, 3))
    }

    @Test
    override fun `list asserts should check for order`() {
        asserts.listEqualityAssert(listOf(1, 2, 3), listOf(1, 2, 3))
    }

    @Test
    override fun `list asserts can be negated`() {
        asserts.listEqualityAssertNegation(listOf(1, 2, 3), listOf(3, 2, 1))
        asserts.listEqualityAssertNegation(listOf(1, 2), listOf(1, 2, 3))
        asserts.listEqualityAssertNegation(listOf(1, 2, 3), listOf(1, 2))
    }

    @Test
    override fun `list asserts should check for item presence`() {
        asserts.itemPresenceAssert(listOf(1, 2, 3), 2)
    }

    @Test
    override fun `list asserts should check for item absence`() {
        asserts.itemAbsenceAssert(listOf(1, 2, 3), 4)
    }

    @Test
    override fun `list asserts should check for multiple item presence`() {
        asserts.multipleItemPresenceAssert(listOf(1, 2, 3), setOf(3, 2))
    }

    @Test
    override fun `list asserts should check for multiple item absence`() {
        asserts.multipleItemAbsenceAssert(listOf(4, 2, 1), setOf(5, 6))
    }

    @Test
    override fun `set asserts should give detailed information`() {
        asserts.setEqualityAssert(setOf(1, 2, 3), setOf(3, 2, 1))
    }

    @Test
    override fun `set asserts can be negated`() {
        asserts.setEqualityAssertNegation(setOf(1, 2, 3), setOf(4, 2, 1, 5))
    }

    @Test
    override fun `map asserts should give detailed information`() {
        asserts.mapEqualityAssert(fizzBuzzMap, fizzBuzzMapCopy)
    }

    @Test
    override fun `map asserts should have different message for values mismatch`() {
        asserts.mapEqualityAssert(fizzBuzzMap, fizzBuzzMapCopy)
    }

    @Test
    override fun `map asserts can be negated`() {
        asserts.mapEqualityAssertNegation(fazzBuzzMap, fizzBuzzMap)
    }

    @Test
    override fun `array asserts should work like others`() {
        asserts.arrayEqualityAssert(arrayOf(1, 2, 3), arrayOf(1, 2, 3))
    }

    @Test
    override fun `array asserts can be negated`() {
        asserts.arrayEqualityAssertNegation(arrayOf(1, 2, 3), arrayOf(4, 5, 6))
    }

    @Test
    override fun `primitive array asserts should work like others`() {
        asserts.primitiveArrayEqualityAssert(byteArrayOf(1, 2, 3), byteArrayOf(1, 2, 3))
    }

    @Test
    override fun `primitive array asserts can be negated`() {
        asserts.primitiveArrayEqualityAssertNegation(byteArrayOf(1, 2, 3), byteArrayOf(4, 5, 6))
    }

    @Test
    override fun `asserts for complex structures should give detailed information`() {
        asserts.structuralAssert(complexMap, complexMapCopy)
    }

    @Test
    override fun `asserts for complex structures should work for more complex cases`() {
        asserts.structuralAssert(complexStructure, complexStructureCopy)
    }

    @Test
    override fun `asserts for complex structures can be negated`() {
        asserts.structuralAssertNegation(complexMap, complexMapUnexpected)
    }

    @Test
    override fun `types for asserts of generic functions should be derived or ignored completely`() {
        asserts.untypedAssert("1", 1.toString())
    }
}