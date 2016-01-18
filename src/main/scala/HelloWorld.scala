
/**
  * Created by adiko on 17/01/2016.
  */
object HelloWorld {

  def square(x: Double) = x * x

  def sumOfAquares(x: Double, y: Double) = square(x) + square(y)

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    println(sumOfAquares(3,4))
  }

}
