package example.polymorphism

/**
  * Created by adiko on 21/01/2016.
  */
trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def nth(n: Int): T

  override def equals(anotherList: Any): Boolean = {
    anotherList match {
      case that: List[T] =>
        isEmpty && that.isEmpty ||
        head == that.head && tail.equals(that.tail)
      case _ => false
    }
  }
}
