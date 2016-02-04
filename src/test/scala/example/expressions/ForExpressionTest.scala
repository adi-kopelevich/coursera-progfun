package example.expressions

import example.sequences.CollectionsExample
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope


/**
  * Created by adiko on 04/02/2016.
  */
class ForExpressionTest extends SpecificationWithJUnit {

  class Context extends Scope {

  }

  "given a positive number n, findAllPairsWhichSumToPrime" should {
    "return a list of positive int pair (i,j) where j<i and i+j is prime" in new Context {
      private val n: Int = 7
      private val expectedResult: List[(Int, Int)] = List((2, 1), (3, 2), (4, 1), (4, 3), (5, 2), (6, 1), (6, 5))
      new ForExpression().findAllPairsWhichSumToPrime(n) must be_===(expectedResult)
    }
  }

  "given 2 lists of doubles, scalarProduct" should {
    "return the sum of the product of each element pair" in new Context {
      new ForExpression().scalarProduct(List(1, 2, 3), List(4, 5, 6)) must beEqualTo(32)
    }
  }

}
