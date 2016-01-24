package example.functions

/**
  * Created by adiko on 24/01/2016.
  */
abstract class Natural {
  def isZero: Boolean
  def pre: Natural
  def suc: Natural = new Succ(this)
  def +(x: Natural): Natural
  def -(x: Natural): Natural

  override def equals(obj: Any): Boolean = {
    obj match {
      case x: Natural => {
        if (isZero) x.isZero
        else pre.equals(x.pre)
      }
      case _ => throw new ClassCastException
    }
  }
}

object Zero extends Natural {
  override def isZero: Boolean = true
  override def pre: Natural = throw new RuntimeException
  override def +(x: Natural): Natural = x
  override def -(x: Natural): Natural = if (x.isZero) Zero else throw new RuntimeException
}

class Succ(natural: Natural) extends Natural {
  override def isZero: Boolean = false
  override def pre: Natural = natural
  override def +(x: Natural): Natural = if (x.isZero) this else this.suc + x.pre
  override def -(x: Natural): Natural = if (x.isZero) this else this.pre - x.pre
}


