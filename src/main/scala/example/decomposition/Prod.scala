package example.decomposition

/**
  * Created by adiko on 25/01/2016.
  */
case class Prod(e1: Expr, e2: Expr) extends Expr {
  override def numValue: Int = throw new Error("Prod is not a number")
  override def varValue: String = throw new Error("Prod is not a var")
  override def rightOp: Expr = e1
  override def leftOp: Expr = e2
}
