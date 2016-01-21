package example.polymorphism

import example.polymorphism

import scala.runtime.Nothing$

/**
  * Created by adiko on 21/01/2016.
  */
class NilList[T] extends polymorphism.List[T] {
  override def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException("Nil has no head")
  override def tail: Nothing = throw new NoSuchElementException("Nil has no tail")
  override def nth(n: Int): T = throw new IndexOutOfBoundsException("Nil has no elements")
}
