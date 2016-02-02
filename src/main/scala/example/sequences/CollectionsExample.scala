package example.sequences

/**
  * Created by adiko on 01/02/2016.
  */
object CollectionsExample extends App {

  def scalarProduct(nums1: List[Double], nums2: List[Double]) = {
    (nums1 zip nums2).map({ case (x, y) => x * y }).sum
    //   same as writing (nums1 zip nums2).map(xy => xy match {case (x, y) => x * y}).sum
  }

  def isPrime(n: Int) = {
    !(2 until n).exists(x => n % x == 0)
  }

  val intArray = Array(1, 2, 3, 44)
  println((intArray map (_ * 2)) mkString ",")

  val str = "Hello World"
  println(str filter (_.isUpper))
  println(str exists (_.isUpper))
  println(str forall (_.isUpper))

  val pairs = List(1, 2, 3) zip str
  println(pairs)

  val hirList = List(List(1, 2), List(3), 4, List(List(5), List(6, 7)))
  //  val flattenList = hirList.flatten

  println(str.flatMap(x => List('.', x)))

  println(intArray.max)
  println(intArray.product)
  println(intArray.sum)
  println(intArray.min)

}
