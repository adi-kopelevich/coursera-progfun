package example.functions

/**
  * Created by adiko on 24/01/2016.
  */


class AnnoFun extends Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 * v1
}

object FunctionsAndObjects extends App {

  val f = (x: Int) => x * x

  val fObj = new Function[Int, Int] {
    def apply(x: Int) = x * x
  }

  println(fObj.apply(7))
  println(f(7))
}




