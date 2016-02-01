package example.lists

/**
  * Created by adiko on 31/01/2016.
  */
object ReductionList {

  def map[T, U](list: List[T], function: T => U): List[U] = {
    (list foldRight List[U]()) (applyFuncAndAddResultToList(function))
  }

  private def applyFuncAndAddResultToList[U, T](function: (T) => U): (T, List[U]) => List[U] = {
    (x, acc) => function(x) :: acc
  }

  def length[T](list: List[T]): Int = {
    (list foldRight 0) (addOneToAcc)
  }

  private def addOneToAcc[T]: (T, Int) => Int = {
    (x, acc) => acc + 1
  }
  def concat[T](strings1: List[T], strings2: List[T]) = {
    (strings1 foldRight strings2) (_ :: _)
  }

  def product(ints: List[Int]): Int = {
    (ints foldLeft 1) (_ * _) // using foldLeft
  }

  def sum(list: List[Int]): Int = {
    (0 :: list) reduceLeft (_ + _) // using reduceLeft
  }

}
