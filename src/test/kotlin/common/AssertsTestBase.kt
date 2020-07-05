package common

internal abstract class AssertsTestBase {
    abstract fun `simple assert should have descriptive message`()

    abstract fun `simple assert can be negated`()

    abstract fun `string can be asserted for containing a substring`()

    abstract fun `string containing assert can be negated`()

    abstract fun `exception assert should look ok`()

    abstract fun `list asserts should give detailed information`()

    abstract fun `list asserts should check for order`()

    abstract fun `list asserts can be negated`()

    abstract fun `list asserts should check for item presence`()

    abstract fun `list asserts should check for item absence`()

    abstract fun `list asserts should check for multiple item presence`()

    abstract fun `list asserts should check for multiple item absence`()

    abstract fun `set asserts should give detailed information`()

    abstract fun `set asserts can be negated`()

    abstract fun `map asserts should give detailed information`()

    abstract fun `map asserts should have different message for values mismatch`()

    abstract fun `map asserts can be negated`()

    abstract fun `array asserts should work like others`()

    abstract fun `array asserts can be negated`()

    abstract fun `primitive array asserts should work like others`()

    abstract fun `primitive array asserts can be negated`()

    abstract fun `asserts for complex structures should give detailed information`()

    abstract fun `asserts for complex structures should work for more complex cases`()

    abstract fun `asserts for complex structures can be negated`()

    abstract fun `types for asserts of generic functions should be derived or ignored completely`()
}



