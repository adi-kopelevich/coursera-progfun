package example.decomposition

/**
  * Created by adiko on 25/01/2016.
  */
trait Expr {
  def numValue: Int
  def varValue: String
  def leftOp: Expr
  def rightOp: Expr
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case _ => throw new Error("Invalid expression")
  }
  def show: String = this match {
    case Number(n) => n.toString
    case Var(s) => s
    case Sum(e1, e2) => s"${e1.show} + ${e2.show}"
    case Prod(Sum(e1, e2), e3) => s"(${e1.show} + ${e2.show}) * ${e3.show}"
    case Prod(e1, e2) => s"${e1.show} * ${e2.show}"
    case _ => throw new Error("Invalid expression")
  }
}




