package example.maps

/**
  * Created by adiko on 06/02/2016.
  */
class Polynomials(val polyMap: Map[Int, Double]) {

  def +(poly2: Polynomials): Polynomials = {
    new Polynomials(polyMap ++ (poly2.polyMap map applySumIfAlreadyExists))
  }

  def applySumIfAlreadyExists(term: (Int, Double)) = {
    val (exp, coeff) = term
    val adjustedCoeff = polyMap get exp match {
      case None => coeff
      case Some(existsCoeff) => existsCoeff + coeff
    }
    (exp, adjustedCoeff)
  }

  override def toString() = {
    val listOfExpressions =
      for ((key, value) <- polyMap.toList.sorted.reverse)
        yield value + "X^" + key
    listOfExpressions mkString " + "
  }


}
