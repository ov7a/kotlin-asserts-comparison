package common

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

open class AssertsFullTest(val asserts: Asserts) {
    @Nested
    @DisplayName(" SuccessfulAsserts")
    internal inner class SuccessfulAsserts : SuccessfulAssertsTestBase(asserts)

    @Nested
    @DisplayName("FailedAsserts")
    internal inner class FailedAsserts : FailedAssertsTestBase(asserts)
}