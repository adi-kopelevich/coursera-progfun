package example.polymorphism

import com.wixpress.hoopoe.test._
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope


/**
  * Created by adiko on 21/01/2016.
  */
class ConsListTest extends SpecificationWithJUnit {


  class ctx extends Scope {
    val firstElement = randomInt
    val secondElement = randomInt
    val thirdElement = randomInt
    val list = new ConsList[Int](firstElement,
      new ConsList[Int](secondElement,
        new ConsList[Int](thirdElement,
          new NilList[Int])))

    val listTail =
      new ConsList[Int](secondElement,
        new ConsList[Int](thirdElement,
          new NilList[Int]))

  }

  "given a list, isEmpty" should {
    "return false" in new ctx {
      list.isEmpty mustEqual(false)
    }
  }

  "given a list, head" should {
    "return the first element in the list" in new ctx {
      list.head mustEqual(firstElement)
    }
  }

  "given a list, tail" should {
    "return a new list without the first element in the list" in new ctx {
      list.tail mustEqual(listTail)
    }
  }

  "given n and a list, nth" should {
    "return the n'th element in the list (starting from 0)" in new ctx {
      list.nth(2) mustEqual thirdElement
    }
  }

  "given n which is out of range, nth" should {
    "throw IndexOutOfBoundsException" in new ctx {
      list.nth(5) must throwA[IndexOutOfBoundsException]
    }
  }
}
