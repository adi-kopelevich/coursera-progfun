package example.lists

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by adiko on 28/01/2016.
  */
class HighOrderListExampleTest extends Specification {

  abstract class Context extends Scope {
    val listOfInts = List(-1, 2, -3, 4)
    val listOfSquareInts = List(1, 4, 9, 16)
  }

  abstract class StringContext extends Scope {
    val listOfStrings = List("a", "a", "a", "b", "c", "c", "a")
    val listOfStringPacked = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
  }

  "given a list of ints, squareList" should {
    "sort the elements in the list" in new Context {
      HighOrderListExample.squareList(listOfInts) must beEqualTo(listOfSquareInts)
    }
  }

  "given a list of ints, posElems" should {
    "returns a list with only the positive elements" in new Context {
      HighOrderListExample.posElems(List(-1, 2, -3, 4)) must beEqualTo(List(2, 4))
    }
  }

  "given a list of strings, pack" should {
    "returns a list of lists where each list contains the consecutive duplicates of the list elements" in new StringContext {
      HighOrderListExample.pack(listOfStrings) must beEqualTo(listOfStringPacked)
    }
  }

  "given a list of strings, encode" should {
    "returns a list of tuples where each list contains the element and the number of consecutive duplicates in the list" in new StringContext {
      val listOfStringsEncoded = List(("a",3), ("b", 1), ("c", 2), ("a", 1))
      HighOrderListExample.encode(listOfStrings) must beEqualTo(listOfStringsEncoded)
    }
  }

}
