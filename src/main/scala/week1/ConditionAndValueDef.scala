package week1

import sun.jvm.hotspot.runtime.amd64.AMD64CurrentFrameGuess

/**
  * Created by adiko on 17/01/2016.
  */
object ConditionAndValueDef {



  def sqrt(x: => Double): Double = {
    def isGoodEnough(guess: Double, x: Double): Boolean = {
      math.abs(guess * guess - x) / x < 0.0000001
    }

    def improve(guess: Double, x: Double) = {
      (guess + x / guess) /2
    }

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x))
        guess
      else
        sqrtIter(improve(guess, x), x)

    sqrtIter(1.0, x)
  }


  def main(args : Array[String]){
    println(sqrt(2))
    println(sqrt(4))
    println(sqrt(1e-6)) // - not percies for small numbers
    println(sqrt(1e60)) // - not termination for large number

  }

}
