package example.decomposition

/**
  * Created by adiko on 25/01/2016.
  */
case class Number(n: Int) extends Expr {
  override def numValue: Int = n
  override def varValue: String = throw new Error("Number is not a var")
  override def leftOp: Expr = throw new Error("Number has no left op")
  override def rightOp: Expr = throw new Error("Number has no right op")
}
