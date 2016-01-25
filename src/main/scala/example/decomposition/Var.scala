package example.decomposition



case class Var(s: String) extends Expr {
  override def numValue: Int = throw new Error("Var is not a number")
  override def varValue: String = s
  override def rightOp: Expr = throw new Error("Var has no right op")
  override def leftOp: Expr = throw new Error("Var has no left op")
}

