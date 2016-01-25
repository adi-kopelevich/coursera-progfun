package example.functions.natural

/**
  * Created by adiko on 25/01/2016.
  */
class Succ(natural: Natural) extends Natural {
  override def isZero: Boolean = false
  override def pre: Natural = natural
  override def +(x: Natural): Natural = if (x.isZero) this else this.suc + x.pre
  override def -(x: Natural): Natural = if (x.isZero) this else this.pre - x.pre
}
