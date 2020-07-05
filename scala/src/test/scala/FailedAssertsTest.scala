import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.reflect.ClassTag

class FailedAssertsTest extends AnyFlatSpec with Matchers {
  "simple assert" should "have descriptive message" in {
    val myValue = 2
    myValue shouldBe 1
  }

  it can "be negated" in {
    val myValue = 2
    myValue should not be 2
  }

  "string" can "be asserted for containing a substring" in {
    "Quick lazy fox" should include("zaly")
  }
  it can "be negated" in {
    "Quick lazy fox" shouldNot include("lazy")
  }

  "exception assert" should "look ok" in {
    val expectedException = intercept[RuntimeException] {
      println("No exceptions")
    }

    expectedException.getMessage shouldBe "Some message"
  }

  "list asserts" should "give detailed information" in {
    List(1, 2, 3) shouldBe List(3, 4, 5)
  }
  they should "check for order" in {
    List(1, 2, 3) shouldBe List(3, 2, 1)
  }
  they can "be negated" in {
    List(1, 2, 3) should not be List(1, 2, 3)
  }
  they should "check for item presence" in {
    List(1, 2, 3) should contain(4)
  }
  they should "check for item absence" in {
    List(1, 2, 3) shouldNot contain(2)
  }
  they should "check for multiple item presence" in {
    List(1, 2, 3) should contain allOf(4, 2)
  }
  they should "check for multiple item absence" in {
    List(4, 2, 1) should contain noneOf(1, 3)
  }

  "set asserts" should "give detailed information" in {
    Set(1, 2, 3) shouldBe Set(3, 4, 5)
  }
  they can "be negated" in {
    Set(1, 2, 3) should not be Set(3, 2, 1)
  }

  "map asserts" should "give detailed information" in {
    val actual = Map(1 -> "1", 2 -> "2", 3 -> "fizz")
    actual shouldBe Map(1 -> "1", 2 -> "2", 3 -> "fizz", 4 -> "4", 5 -> "buzz")
  }
  they should "have different message for values mismatch" in {
    val actual = Map(1 -> "1", 2 -> "2", 3 -> "fazz", 4 -> "4", 5 -> "buzz")
    actual shouldBe Map(1 -> "1", 2 -> "2", 3 -> "fizz", 4 -> "4", 5 -> "buzz")
  }
  they can "be negated" in {
    val actual = Map(1 -> "1", 2 -> "2", 3 -> "fizz", 4 -> "4", 5 -> "buzz")
    actual should not be Map(1 -> "1", 2 -> "2", 3 -> "fizz", 4 -> "4", 5 -> "buzz")
  }

  "array asserts" should "work like others" in {
    Array[Any](1, "2", null, 4L) should contain theSameElementsInOrderAs Array[Any](3, 4, "5")
  }
  they should "can be negated" in {
    Array[Any](1, "2", null, 4L) shouldNot contain theSameElementsInOrderAs Array[Any](1, "2", null, 4L)
  }

  "primitive array asserts" should "work like others" in {
    Array[Byte](1, 2, 3) should contain theSameElementsInOrderAs Array[Byte](3, 4, 5)
  }
  they should "can be negated" in {
    Array[Byte](1, 2, 3) shouldNot contain theSameElementsInOrderAs Array[Byte](1, 2, 3)
  }

  "asserts for complex structures" should "give detailed information" in {
    val actual = Map(
      "array" -> Array(1, 2),
      "list" -> List(1, 2, 3),
      "int" -> 2,
      "string" -> "sss",
      "null" -> null
    )

    val expected = Map(
      "list" -> List(1, 2, 3),
      "int" -> 2,
      "string" -> "sss",
      "null" -> null,
      "unexpectedKey" -> "some_value"
    )

    actual should contain theSameElementsAs expected
  }
  they should "work for more complex cases" in {
    val actual = Map(
      "array" -> Array(1, 2),
      "list" -> List(1, 2, 3),
      "bytearray" -> Array[Byte](1, 2, 3, 4),
      "int" -> 2,
      "string" -> "sss",
      "map" -> Map(
        "2" -> 2,
        "lissst" -> List("1", 2, "5", null, Map("1" -> Array[Byte](1, 2, 3, 5)), Set(List(1, 2, 3))),
        "bytearray" -> Array[Byte](1, 2, 3, 5)
      ),
      "null" -> null
    )

    val expected = Map(
      "array" -> Array(1, 2),
      "list" -> List(1, 2, 3),
      "bytearray" -> Array[Byte](1, 2, 3, 4, 5),
      "int" -> 2,
      "string" -> "sss",
      "map" -> Map(
        "2" -> 2,
        "4" -> "3",
        "lissst" -> List("1", 2, "5", null, Map("1" -> Array[Byte](1, 2, 3, 5)), Set(List(1, 2, 3, 3))),
        "bytearray" -> Array[Byte](1, 2, 3, 5)
      ),
      "null" -> null
    )

    actual should contain theSameElementsAs expected
  }
  they can "be negated" in {
    val actual = Map(
      "array" -> Array(1, 2),
      "list" -> List(1, 2, 3),
      "int" -> 2,
      "string" -> "sss",
      "null" -> null
    )

    //Copy-paste to avoid compare by reference
    val expected = Map(
      "array" -> Array(1, 2),
      "list" -> List(1, 2, 3),
      "int" -> 2,
      "string" -> "sss",
      "null" -> null
    )

    actual should contain theSameElementsAs expected
  }

  "types for asserts of generic functions" should "be derived or ignored completely" in {
    def genericType[T](desiredType: String): T = (desiredType match {
      case "str" => "string"
      case "int" => 1
    }).asInstanceOf[T]

    genericType[Int]("str") shouldBe 1
  }

}