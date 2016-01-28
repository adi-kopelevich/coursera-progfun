package example.lists

/**
  * Created by adiko on 28/01/2016.
  */
object HighOrderListExample {

  def encode[T](listOfStrings: List[T]): List[(T, Int)] = {
    pack(listOfStrings) map (listOfLists => (listOfLists.head, listOfLists.length))
  }

  def pack[T](strings: List[T]): List[List[T]] = {
    strings match {
      case List() => List()
      case head :: tail => {
        val (partationByHead, partationByHeadRest) = strings.span(filterEquals(head))
        partationByHead :: pack(partationByHeadRest)
      }
    }
  }

  def filterEquals[T](head: T): (T) => Boolean = {
    y => y.equals(head)
  }
  def posElems(ints: List[Int]): List[Int] = {
    ints filter (n => n > 0)
  }


  def squareList(ints: List[Int]): List[Int] = {
    ints map (n => n * n)
  }

}
