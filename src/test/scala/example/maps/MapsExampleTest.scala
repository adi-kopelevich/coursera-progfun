package example.maps

import example.expressions.{QueriesWithFor, Book}
import org.specs2.mutable.{SpecificationWithJUnit, Specification}
import org.specs2.specification.Scope

/**
  * Created by adiko on 05/02/2016.
  */
class MapsExampleTest extends SpecificationWithJUnit {


  class Context extends Scope {

  }

  "given a lib of books and a name, findAuthorsBooks" should {
    "return a list of books which its author is the given name" in new Context {
    }
  }

}
