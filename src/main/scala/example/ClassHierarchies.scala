package example

import sun.invoke.empty.Empty

/**
  * Created by adiko on 19/01/2016.
  */
object ClassHierarchies extends App {

  abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean

    def union(otherSet: IntSet): IntSet
  }

  object EmptyNode extends IntSet {
    override def incl(x: Int): IntSet = new NonEmptyNode(x, EmptyNode, EmptyNode)
    override def contains(x: Int): Boolean = false
    override def toString = "."
    override def union(otherSet: IntSet): IntSet = otherSet
  }

  class NonEmptyNode(value: Int, left: IntSet, right: IntSet) extends IntSet {

    override def incl(x: Int): IntSet = {
      if (x == value)
        this
      else if (x < value)
        new NonEmptyNode(value, left incl x, right)
      else
        new NonEmptyNode(value, left, right incl x)

    }

    override def contains(x: Int): Boolean = {
      if (x == value)
        true
      else if (x < value)
        left contains x
      else
        right contains x
    }

    override def toString = "{" + left + value + right + "}"

    override def union(otherSet: IntSet): IntSet = {
      ((left union right) union otherSet) incl value
    }
  }

  val t1 = new NonEmptyNode(3, EmptyNode, EmptyNode)
  val t2 = t1 incl 4

  println(t1)
  println(t2)



}
