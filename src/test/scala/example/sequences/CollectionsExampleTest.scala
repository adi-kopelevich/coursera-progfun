package example.sequences

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by adiko on 01/02/2016.
  */
class CollectionsExampleTest extends SpecificationWithJUnit {

  class Context extends Scope {


  }

  "given 2 lists of doubles, scalarProduct" should {
    "return the sum of the product of each element pair" in new Context {
      CollectionsExample.scalarProduct(List(1,2,3), List(4,5,6)) must beEqualTo(32)
    }
  }

  "given a number n, isPrime" should {
    "return false if n is divisible by one of the numbers between 1..n" in new Context {
      CollectionsExample.isPrime(9) must beFalse
    }

    "return true if n is not divisible by all of the numbers between 1..n" in new Context {
      CollectionsExample.isPrime(7) must beTrue
    }

  }

}
