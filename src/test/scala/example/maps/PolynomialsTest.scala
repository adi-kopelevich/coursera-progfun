package example.maps

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by adiko on 06/02/2016.
  */
class PolynomialsTest extends SpecificationWithJUnit {

  class Context extends Scope {
  }

  "given 2 polynomials, +" should {
    "return a new polynomial representing their sum" in new Context {
      val poly1 = new Polynomials(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
      val poly2 = new Polynomials(Map(0 -> 3.0, 3 -> 7.0))
      val ploy1plus2 = new Polynomials(Map(0 -> 3.0, 1 -> 2.0, 3 -> 11.0, 5 -> 6.2))
      (poly1 + poly2).toString() must be_===(ploy1plus2.toString())
    }
  }
}
