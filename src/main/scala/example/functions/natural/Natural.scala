package example.functions.natural

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
