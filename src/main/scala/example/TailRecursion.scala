package example

import scala.annotation.tailrec

/**
  * Created by adiko on 17/01/2016.
  */
object TailRecursion extends App{

  def factorial(n: Int): Int = {
    @tailrec def loop(acc: Int, n: Int): Int ={
      if (n == 0)
        acc
      else
        loop(acc * n , n-1)
    }
    loop(1, n)
  }

  println(factorial(5))
}
