package example.lists

import com.wixpress.hoopoe.test._
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by adiko on 31/01/2016.
  */
class ReductionListTest extends Specification {

  abstract class Context extends Scope {
    val firstInt = randomInt
    val secondInt = randomInt
    val thirdInt = randomInt
    val sumOfInts = firstInt + secondInt + thirdInt
    val productOfInts = firstInt * secondInt * thirdInt
    val listA = List("a1", "a2", "a3")
    val listB = List("b1", "b2", "b3")
    val listAB = List("a1", "a2", "a3", "b1", "b2", "b3")
  }

  "given a int list, sum" should {
    "should return the sum of the list elements" in new Context {
      ReductionList.sum(List(firstInt, secondInt, thirdInt)) must beEqualTo(sumOfInts)
    }
  }

  "given a int list, product" should {
    "should return the product of the list elements" in new Context {
      ReductionList.product(List(firstInt, secondInt, thirdInt)) must beEqualTo(productOfInts)
    }
  }

  "given a list, concat" should {
    "should return a list of elements from both given lists in the order they were provided" in new Context {
      ReductionList.concat(listA, listB) must beEqualTo(listAB)
    }
  }

  "given a list, length" should {
    "should return the number of elements in the list" in new Context {
      ReductionList.length(listA) must beEqualTo(3)
    }
  }

  "given a list, map" should {
    "should return the the list where each alements was applied with the mapping function" in new Context {
      val lengthPlus1: String => Int = x => x.size + 1
      private val listOfStrings = List("a", "aa", "aaa")
      private val listOfStringsSizePlusOne = List(2, 3, 4)
      ReductionList.map(listOfStrings, lengthPlus1) must beEqualTo(listOfStringsSizePlusOne)
    }

  }

}
