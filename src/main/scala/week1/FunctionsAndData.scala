package week1

/**
  * Created by adiko on 18/01/2016.
  */
object FunctionsAndData extends App {

  class Rational(x: Int, y: Int) {

    require(y != 0, "denominator must not be equal to zero") // produce illegal args exception (pre-condition)
//    assert(y >0) // produce assertion error (checks the code of the function)

    def this(x: Int) = this(x,1) // ctor overloading...

    private val g = gcd(x, y)

    val numer = x / g
    val denom = y / g

    def add(s: Rational): Rational = {
      new Rational(numer * s.denom + denom * s.numer, denom * s.denom)
    }

    def sub(s: Rational): Rational = {
      add(s.neg)
    }

    def neg: Rational = {
      new Rational(-numer, denom)
    }

    def less(s: Rational) = numer * s.denom < s.numer * denom

    def max(s: Rational) = if (this.less(s)) this else s

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0)
        a
      else
        gcd(b, a % b)
    }

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
  println(rationalNum1.neg.toString)
  println(rationalNum1.add(rationalNum2).toString)
  println(rationalNum1.sub(rationalNum2).toString)
  println(rationalNum1.sub(rationalNum2).sub(rationalNum3))
  println(rationalNum1.add(rationalNum1))
}

