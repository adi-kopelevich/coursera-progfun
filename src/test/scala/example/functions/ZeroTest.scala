package example.functions

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by adiko on 24/01/2016.
  */
class ZeroTest extends SpecificationWithJUnit {


  class ctx extends Scope {


  }

  "given a zero number" should {

    "isZero should return true" in new ctx {
      Zero.isZero must beEqualTo(true)
    }

    "pre must throw a runtime exception" in new ctx {
      Zero.pre must throwA[RuntimeException]
    }

    "suc must be equal to new Succ(Zero)" in new ctx {
      Zero.suc must beEqualTo(new Succ(Zero))
    }

    "+ X must be equal to X" in new ctx {
      val succ: Succ = new Succ(Zero)
      Zero + succ must beEqualTo(succ)
    }

    "- X must throw a runtime exception" in new ctx {
      val succ: Succ = new Succ(Zero)
      Zero - succ must throwA[RuntimeException]
    }
  }
}
