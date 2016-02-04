package example.set

/**
  * Created by adiko on 04/02/2016.
  */
object SetExample extends App {

  val fruits = Set("apple", "banana", "pear")
  val aSet = (1 to 6).toSet
  println(aSet map (_ + 2))
  println(aSet map (_ / 2))
  println(fruits filter (_.startsWith("app")))
  println(fruits filter (x => x.contains("e")))
  println(fruits.nonEmpty)


}
