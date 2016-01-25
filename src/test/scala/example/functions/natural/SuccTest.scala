package example.functions.natural

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by adiko on 24/01/2016.
  */
class SuccTest extends SpecificationWithJUnit {


  class ctx extends Scope {


  }

  "given a Succ number" should {

    "isZero return false" in new ctx {
      new Succ(Zero).isZero must beEqualTo(false)
    }

    "pre must return the predecessor" in new ctx {
      val one = new Succ(Zero)
      one.pre must beEqualTo(Zero)
    }

    "suc must return the successor" in new ctx {
      val one = new Succ(Zero)
      val two = new Succ(one)
      one.suc must beEqualTo(two)
    }

    "+ X must be equal to number+X" in new ctx {
      val one = new Succ(Zero)
      val two = new Succ(one)
      one + one must beEqualTo(two)
    }

    "- X must return the Succ for the diff" in new ctx {
      val one = new Succ(Zero)
      val two = new Succ(one)
      two - one must beEqualTo(one)
    }
  }
}
