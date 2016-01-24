package example.polymorphism

import example.polymorphism

import scala.runtime.Nothing$

/**
  * Created by adiko on 21/01/2016.
  */
object NilList extends polymorphism.List[Nothing] {
  override def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException("Nil has no head")
  override def tail: Nothing = throw new NoSuchElementException("Nil has no tail")
  override def nth(n: Int): Nothing = throw new IndexOutOfBoundsException("Nil has no elements")
}
