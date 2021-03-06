package example.polymorphism

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by adiko on 21/01/2016.
  */
class NilListTest extends Specification {

  class ctx extends Scope {
    val list = NilList
  }

  "given n and an Nil list, isEmpry" should {
    "return true" in new ctx {
      list.isEmpty mustEqual (true)
    }
  }

//  "given n and an Nil list, nth" should {
//    "throw IndexOutOfBoundsException" in new ctx {
//      list.nth(2) must throwA[IndexOutOfBoundsException]
//    }
//  }


}
