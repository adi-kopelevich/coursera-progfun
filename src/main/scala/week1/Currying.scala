package week1

/**
  * Created by adiko on 18/01/2016.
  */
object Currying extends App {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def loop(a: Int, b: Int): Int = {
      if (a > b)
        0
      else
        f(a) + loop(a + 1, b)
    }
    loop
  }

  println(sum(x => x * x)(3, 5))

  def product(f: Int => Int)(lower: Int, upper: Int): Int = {
    //    def loop(lower: Int, upper: Int): Int = {
    if (lower > upper)
      1
    else
      f(lower) * product(f)(lower + 1, upper)
    //    }
    //    loop
  }

  def factorial(x: Int): Int = {
    product(y => y)(1, x)
  }

  println(product(x => x)(3, 5))
  println(factorial(5))

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, base: Int)(a: Int, b: Int): Int = {
    if (a > b)
      base
    else
      combine(f(a), mapReduce(f, combine, base)(a + 1, b))
  }

  //  mapReduce(x => x * x, (x, y) => x * y, 1)

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = math.abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(initGuess: Double) = {
    def iter(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next))
        next
      else
        iter(next)
    }
    iter(initGuess)
  }

  println(fixedPoint(x => 1 + x / 2)(1))

  def avgDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

//  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)
  def sqrt(x: Double) = fixedPoint(avgDamp(y => x/y))(x)

  println(sqrt(2))

}
