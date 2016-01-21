package example.polymorphism

import example.polymorphism

/**
  * Created by adiko on 21/01/2016.
  */
class Polymorphism {

  def singleton[T](elem: T) = new ConsList[T](elem, new NilList[T])

  singleton[Int](1)
  singleton(1)
  singleton[Boolean](true)
  singleton(true)

  def nth[T](n: Int, list: polymorphism.List[T]): Unit = {
    if (n < 0 || list.isEmpty)
      throw new IndexOutOfBoundsException
    else if (n == 0)
      list.head
    else
      nth(n - 1, list.tail)
  }


}







