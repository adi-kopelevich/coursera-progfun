package example.functions.natural

/**
  * Created by adiko on 25/01/2016.
  */
object Zero extends Natural {
  override def isZero: Boolean = true
  override def pre: Natural = throw new RuntimeException
  override def +(x: Natural): Natural = x
  override def -(x: Natural): Natural = if (x.isZero) Zero else throw new RuntimeException
}
