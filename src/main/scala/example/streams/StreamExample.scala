package example.streams

import example.sequences.CollectionsExample._

/**
  * Created by adiko on 09/02/2016.
  */
object StreamExample extends App {

  println(((102 to 1000).toStream filter isPrime) (0))
  println((streamRange(102, 1000) filter isPrime) (0))

  val naturalNumbers = from(0)
  val multiOfFours = naturalNumbers map (_ * 4)

  println((multiOfFours take 20).toList)

  private val primes = sieve(from(2))
  println((primes take 100).toList)

  println(sqrtStream(9))

  def streamRange(low: Int, high: Int): Stream[Int] = {
    if (low >= high)
      Stream.empty
    else {
      //      Stream.cons(low, streamRange(low + 1, high))
      low #:: streamRange(low + 1, high)
    }
  }

  def listRange(low: Int, high: Int): List[Int] = {
    if (low >= high)
      Nil
    else {
      low :: listRange(low + 1, high)
    }
  }

  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  def sieve(range: Stream[Int]): Stream[Int] = {
    val prime: Int = range.head
    prime #:: sieve(range.tail filter (_ % prime != 0))
  }


  def sqrtStream(x: Double): Double = {
    def improveGuess(guess: Double) = (guess + x / guess) / 2
    def isGoodEnough(guess: Double) = math.abs((guess* guess -x)/guess) < 0.01

    lazy val guesses: Stream[Double] = 1 #:: (guesses map improveGuess)
    (guesses filter isGoodEnough).head
  }

}
