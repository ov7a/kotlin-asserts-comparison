package common

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

internal abstract class TestReportValidator : TestWatcher, AfterAllCallback {
    protected val succeeded = mutableSetOf<String>()
    protected val failed = mutableSetOf<String>()

    abstract val collectionToCheck: Set<String>
    abstract val hint: String

    override fun afterAll(context: ExtensionContext?) {
        compareSets(collectionToCheck, expectedTests, hint)

        val allTests = succeeded + failed
        compareSets(allTests, expectedTests, "Known")
    }

    private fun <T> compareSets(actual: Set<T>, expected: Set<T>, hint: String) {
        val extra = actual - expected
        val missing = expected - actual
        if (extra.isNotEmpty() || missing.isNotEmpty()) {
            throw AssertionError(
                "$hint test sets do not match.\n" +
                        "Extra tests (${extra.size}):\n${extra.joinToString(separator = "\n\t", prefix = "\t")}\n" +
                        "missing tests (${missing.size}):\n${missing.joinToString(separator = "\n\t", prefix = "\t")}"
            )
        }
    }

    private val ExtensionContext.name: String
        get() = this.displayName.removeSuffix("()")

    override fun testSuccessful(context: ExtensionContext) {
        succeeded.add(context.name)
    }

    override fun testDisabled(context: ExtensionContext, reason: Optional<String>) {
        throw IllegalStateException("All test should be run, but `${context.name}` was disabled ${reason.map { "because $it" }}")
    }

    override fun testAborted(context: ExtensionContext, cause: Throwable?) {
        throw IllegalStateException("All test should be run, but `${context.name}` was aborted ${cause?.message.let { "because $it" }}")
    }

    override fun testFailed(context: ExtensionContext, cause: Throwable?) {
        failed.add(context.name)
    }

    companion object {
        private val objectMembers = JvmType.Object::class.members.map { it.name }
        val expectedTests = AssertsTestBase::class.members.map { it.name }.toSet().minus(objectMembers)
    }
}

internal class SuccessfulTestReportValidator : TestReportValidator() {
    override val collectionToCheck = succeeded
    override val hint = "Succeeded"
}

internal class FailedTestReportValidator : TestReportValidator() {
    override val collectionToCheck = failed
    override val hint = "Failed"
}