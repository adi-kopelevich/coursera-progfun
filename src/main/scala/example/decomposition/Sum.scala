package example.decomposition

/**
  * Created by adiko on 25/01/2016.
  */
case class Sum(e1: Expr, e2: Expr) extends Expr {
  override def numValue: Int = throw new Error("Sum is not a number")
  override def varValue: String = throw new Error("Sum is not a var")
  override def leftOp: Expr = e1
  override def rightOp: Expr = e2
}
