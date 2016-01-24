package example.polymorphism

import example.polymorphism

/**
  * Created by adiko on 21/01/2016.
  */
class ConsList[T](val head: T, val tail: polymorphism.List[T]) extends List[T] {

  override def isEmpty = false

  override def nth(n: Int): T = {
    if (n < 0)
      throw new IndexOutOfBoundsException
    else if (n == 0)
      head
    else
      tail.nth(n - 1)
  }
}
