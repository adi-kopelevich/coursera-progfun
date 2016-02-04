package example.set

/**
  * Created by adiko on 04/02/2016.
  */
object NQueens extends App {

  def queens(n: Int): Set[List[Int]] = {

    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else {
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
      }
    }
    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val rowIndices = (0 to row).reverse
    val queensPosTuple = rowIndices zip queens
    queensPosTuple forall {
      case (rowIdx, colIdx) => rowIdx != row && notOnADiagonal((rowIdx, colIdx), (row, col))
    }
  }

  def notOnADiagonal(posA: (Int, Int), posB: (Int, Int)): Boolean = {
    posA match {
      case (rowA, colA) => posB match {
        case (rowB, colB) => math.abs(colB - colA) != math.abs(rowB - rowA)
      }
    }
  }

  def show(queens: List[Int]): Unit = {
    val lines =
      for (col <- queens.reverse)
        yield List.fill(queens.length)("#").updated(col, "Q").mkString("\n")
    println(lines)
  }

  queens(4) map show
}
