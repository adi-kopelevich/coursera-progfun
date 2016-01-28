package example.lists

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by adiko on 26/01/2016.
  */
class ListsExampleTest extends Specification {

  abstract class Context extends Scope {
    val listOfInts1 = 9 :: 4 :: 2 :: 7 :: 3 :: Nil
    val sortedListOfInts = 2 :: 3 :: 4 :: 7 :: 9 :: Nil
    val listOfIntsWithRepeat = 9 :: 4 :: 2 :: 4 :: 3 :: Nil
    val sortedListOfIntsWithRepeat = 2 :: 3 :: 4 :: 4 :: 9 :: Nil
    val initOfListOfInits = 9 :: 4 :: 2 :: 7 :: Nil
    val listsofInt2 = 1 :: 2 :: 3 :: Nil
    val concatOfList1andList2 = 9 :: 4 :: 2 :: 7 :: 3 :: 1 :: 2 :: 3 :: Nil
    val listOfInts1WithoutThe4thElement = 9 :: 4 :: 2 :: 3 :: Nil
  }

  "given a list of ints, isort" should {
    "sort the elements in the list" in new Context {
      ListsExample.isort(listOfInts1) must beEqualTo(sortedListOfInts)
    }

    "sort the elements in the list with repeats" in new Context {
      ListsExample.isort(listOfIntsWithRepeat) must beEqualTo(sortedListOfIntsWithRepeat)
    }
  }

  "given a list of ints, msort" should {
    "sort the elements in the list" in new Context {
      ListsExample.msort(listOfInts1) must beEqualTo(sortedListOfInts)
    }

    "sort the elements in the list with repeats" in new Context {
      ListsExample.msort(listOfIntsWithRepeat) must beEqualTo(sortedListOfIntsWithRepeat)
    }
  }

  "given a list of ints, init" should {
    "return a list consisting of the all elements except the last one" in new Context {
      ListsExample.init(listOfInts1) must beEqualTo(initOfListOfInits)
    }

    "throw an excption if the list is empty" in new Context {
      ListsExample.init(List()) must throwA[Error]
    }
  }

  "given 2 lists of ints, xs and ys, concat" should {
    "return a list where all elements of ys are followed by the elements of xs" in new Context {
      ListsExample.concat(listOfInts1, listsofInt2) must beEqualTo(concatOfList1andList2)
    }
  }

  "given a lists of ints and an index n, removeAt" should {
    "return a list containing all the elements of the list except the n'th element" in new Context {
      ListsExample.removeAt(3, listOfInts1) must beEqualTo(listOfInts1WithoutThe4thElement)
    }

    "thorw an IndexOutOfBoundsException in case the list is empty" in new Context {
      ListsExample.removeAt(4, List()) must throwA[IndexOutOfBoundsException]
    }

    "thorw an IndexOutOfBounds in case the index is out of bounds" in new Context {
      ListsExample.removeAt(5, listOfInts1) must throwA[IndexOutOfBoundsException]
    }
  }

  "given a lists of that contains List[Int] as well as Int elements, flatten" should {
    "return a list containing all the Int elements flattend to the same list" in new Context {
      ListsExample.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) must beEqualTo(List(1, 1, 2, 3, 5, 8))
    }
  }

}
