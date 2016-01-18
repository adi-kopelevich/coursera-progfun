package week1

/**
  * Created by adiko on 18/01/2016.
  */
object FunctionsAndData extends App {

  class Rational(x: Int, y: Int) {
    def numer = x

    def denom = y

    def add(s: Rational): Rational = {
      new Rational(numer * s.denom + denom * s.numer, denom * s.denom)
    }

    def sub(s: Rational): Rational = {
      add(s.neg)
    }

    def neg: Rational = {
      new Rational(-numer, denom)
    }

    override def toString(): String = {
      numer + "/" + denom
    }
  }

  def rationalNum1 = new Rational(1, 3)
  def rationalNum2 = new Rational(5, 7)
  def rationalNum3 = new Rational(3, 2)

  println(rationalNum1.toString)
  println(rationalNum2.toString)
  println(rationalNum3.toString)
  println(rationalNum1.neg.toString)
  println(rationalNum1.add(rationalNum2).toString)
  println(rationalNum1.sub(rationalNum2).toString)
  println(rationalNum1.sub(rationalNum2).sub(rationalNum3))
}

