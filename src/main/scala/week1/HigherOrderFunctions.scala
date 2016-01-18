package week1

/**
  * Created by adiko on 18/01/2016.
  */
object HigherOrderFunctions extends App {


  def sumIntBetween(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      a + sumIntBetween(a + 1, b)
  }

  def factorial(a: Int): Int = {
    if (a > 0)
      a * factorial(a - 1)
    else 1
  }

  def sumOfFactorial(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      factorial(a) + sumOfFactorial(a + 1, b)

  }

  def sumOfFuncBetween(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      f(a) + sumOfFuncBetween(f, a + 1, b)
  }

  def sumOfFactorialBetween(a: Int, b: Int) = sumOfFuncBetween(factorial, a, b)

  def sumOfIntBetween(a: Int, b: Int) = sumOfFuncBetween(x => x, a, b) // anonymous function - identity

  println(sumOfFactorialBetween(1, 5))
  println(sumOfFactorial(1, 5))


  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b)
        acc
      else
        loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }

  println(sum(x => x)(1, 5))
  println(sum(x => x * x)(3, 5))

}
