package week1

/**
  * Created by adiko on 18/01/2016.
  */
object FunctionsAndData extends App {

  class Rational(x: Int, y: Int) {

    require(y != 0, "denominator must not be equal to zero") // produce illegal args exception (pre-condition)
//    assert(y >0) // produce assertion error (checks the code of the function)

    def this(x: Int) = this(x,1) // ctor overloading...


    private def gcd(a: Int, b: Int): Int = {
      if (b == 0)
        a
      else
        gcd(b, a % b)
    }

    private val g = gcd(x, y)

    def numer = x / g
    def denom = y / g

    def + (s: Rational): Rational = {
      new Rational(numer * s.denom + denom * s.numer, denom * s.denom)
    }

    def - (s: Rational): Rational = {
      this + -s
    }

    def unary_- : Rational = {
      new Rational(-numer, denom)
    }

    def < (s: Rational) = numer * s.denom < s.numer * denom

    def max(s: Rational) = if (this < s) this else s


    override def toString(): String = {
      numer + "/" + denom
    }
  }

  def rationalNum1 = new Rational(1, 3)

  def rationalNum2 = new Rational(5, 7)

  def rationalNum3 = new Rational(3, 2)

  def rationalNum4 = new Rational(2)

  println(rationalNum1.toString)
  println(rationalNum2.toString)
  println(rationalNum3.toString)
  println(-rationalNum1)
  println(rationalNum1 + rationalNum2)
  println(rationalNum4 - rationalNum1)
  println(rationalNum1 - rationalNum2 - rationalNum3)

}

