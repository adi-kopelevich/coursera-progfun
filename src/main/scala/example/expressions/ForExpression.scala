package example.expressions

import example.sequences.CollectionsExample._

/**
  * Created by adiko on 04/02/2016.
  */
class ForExpression {

  def scalarProduct(ints1: List[Int], ints2: List[Int]): Int = {
    (for {
      (a, b) <- ints1 zip ints2
    } yield a * b).sum
  }

  def findAllPairsWhichSumToPrime(n: Int): Seq[Tuple2[Int, Int]] = {
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)
  }

}
