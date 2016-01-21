
/**
  * Created by adiko on 17/01/2016.
  */
object HelloWorld extends App {

  def square(x: Double) = x * x

  def sumOfAquares(x: Double, y: Double) = square(x) + square(y)


  new example.FunctionsAndData.Rational(1, 2)

  import example.FunctionsAndData._

  println(new Rational(2, 3))


  println("Hello, world!")
  println(sumOfAquares(3, 4))

  val x = null
  val y: String = x
//  val z: Int = null

  println(x)
  println(y)

  def error(msg: String) = throw new Error(msg)
  error("test error")

}
