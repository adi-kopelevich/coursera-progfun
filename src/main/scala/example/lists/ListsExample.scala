package example.lists

/**
  * Created by adiko on 25/01/2016.
  */
object ListsExample extends App {

  // immutable and recursive
  // arrays are mutable and flat
  val fruit: List[String] = List("apples", "oranges", "pears")

  val nums: List[Int] = List(1, 2, 3, 4)

  val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty: List[Nothing] = List()
  val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
  val fruit3 = "apples" :: "oranges" :: "pears" :: Nil

  val fruit4 = Nil.::("pears").::("oranges").::("apples")

  println(fruit.equals(fruit2))
  println(fruit.equals(fruit3))
  println(fruit.equals(fruit4))

  def isort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case head :: tail => insert(head, isort(tail))
    }
  }

  def insert(listElement: Int, sortedList: List[Int]): List[Int] = {
    sortedList match {
      case List() => listElement :: Nil
      case head :: tail => {
        if (listElement <= head)
          listElement :: sortedList
        else
          head :: insert(listElement, tail)
      }
    }
  }

  def msort[T](xs: List[T])(implicit ordering: Ordering[T]): List[T] = {
    xs match {
      case List() => List()
      case List(x) => List(x)
      case List(x, y) => {
        if (ordering.lt(x, y))
          xs
        else
          xs.reverse
      }
      case list: List[T] => {
        val whereToChop = list.length / 2
        val (listPrefix, listSuffix) = list splitAt whereToChop
        merge[T](msort[T](listPrefix)(ordering), msort[T](listSuffix)(ordering))(ordering)
      }
    }
  }

  def merge[T](list1: List[T], list2: List[T])(implicit ordering: Ordering[T]): List[T] = {
    (list1, list2) match {
      case (List(), _) => list2
      case (_, List()) => list1
      case (head1 :: tail1, head2 :: tail2) => {
        if (ordering.lt(head1, head2))
          head1 :: merge(tail1, list2)(ordering)
        else
          head2 :: merge(list1, tail2)(ordering)
      }
    }
  }

  def init(xs: List[Int]): List[Int] = {
    xs match {
      case List() => throw new Error("Empty list dosent have init")
      case List(x) => List()
      case head :: tail => head :: init(tail)
    }
  }

  def concat(xs: List[Int], ys: List[Int]): List[Int] = {
    xs match {
      case List() => ys
      case xsHead :: xsTail => xsHead :: concat(xsTail, ys)
    }
  }

  def removeAt(n: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || (xs.length <= n))
      throw new IndexOutOfBoundsException
    else (xs take n) ::: (xs drop n + 1)


  def flatten(xs: List[Any]): List[Any] = {
    xs match {
      case List() => List()
      case head :: tail => head match {
        case x: Int => x :: flatten(tail)
        case y: List[Any] => flatten(y) ::: flatten(tail)
      }
    }
  }
}


