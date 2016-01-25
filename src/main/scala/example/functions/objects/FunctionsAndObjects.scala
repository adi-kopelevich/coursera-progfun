package example.functions.objects

/**
  * Created by adiko on 25/01/2016.
  */
object FunctionsAndObjects extends App {

  val f = (x: Int) => x * x

  val fObj = new Function[Int, Int] {
    def apply(x: Int) = x * x
  }

  println(fObj.apply(7))
  println(f(7))
}
