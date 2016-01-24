package example.polymorphism

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import com.wixpress.hoopoe.test._


/**
  * Created by adiko on 24/01/2016.
  */

class IntListTest extends SpecificationWithJUnit {

  class ctx extends Scope {

  }

  "given no params, IntList" should {
    "return an empty list" in new ctx {
      IntList() must beEqualTo(new NilList)
    }
  }

  "given one param, IntList(x)" should {
    "return an list with one element x" in new ctx {
      val element = randomInt
      IntList(element) must beEqualTo(new ConsList[Int](element, new NilList[Int]))
    }
  }

  "given two params, IntList(x, y)" should {
    "return a list with two elements where x is the head and is followed by y" in new ctx {
      val firstElement = randomInt
      val secondElement = randomInt

      IntList(firstElement, secondElement) must beEqualTo(new ConsList[Int](firstElement,
        new ConsList[Int](secondElement,
          new NilList[Int])))
    }
  }


}
