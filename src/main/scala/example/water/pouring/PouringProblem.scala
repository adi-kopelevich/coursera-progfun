package example.water.pouring

/**
  * Created by adiko on 10/02/2016.
  */


case class PouringProblem(capacity: Vector[Int]) {

  val initState = capacity map (_ => 0)
  val glasses = 0 until capacity.length

  val moves =
    (for (glass <- glasses) yield EmptyGlass(glass)) ++
      (for (glass <- glasses) yield FillGlass(glass)) ++
      (for (fromGlass <- glasses; toGlass <- glasses; if fromGlass != toGlass) yield PourGlasses(fromGlass, toGlass))

  trait Move {
    def change(state: GlassesState): GlassesState
  }

  case class EmptyGlass(glass: Int) extends Move {
    override def change(state: GlassesState): GlassesState = state updated(glass, 0)
  }

  case class FillGlass(glass: Int) extends Move {
    override def change(state: GlassesState): GlassesState = state updated(glass, capacity(glass))
  }

  case class PourGlasses(from: Int, to: Int) extends Move {
    override def change(state: GlassesState): GlassesState = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated(from, state(from) - amount) updated(to, state(to) + amount)
    }
  }

  class Path(history: List[Move], val endState: GlassesState) {

    //    def endState: GlassesState = trackState(history)
    //    def trackState(moves: List[Move]): GlassesState = moves match {
    //      case List() => initState
    //      case head :: tail => head change trackState(tail)
    //    }

    def extend(move: Move) = new Path(move :: history, move change endState)

    override def toString = (history.reverse mkString " ") + "==> " + endState
  }

  val initialPath = new Path(Nil, initState)

  def from(paths: Set[Path], explored: Set[GlassesState]): Stream[Set[Path]] = {
    if (paths.isEmpty) {
      Stream.Empty
    } else {
      val more = for {
        path <- paths
        next <- moves map path.extend
        if !(explored contains next.endState)
      } yield next
      paths #:: from(more, explored ++ (more map (_.endState)))
    }
  }

  val pathSets = from(Set(initialPath), Set(initState))

  def solution(target: Int): Stream[Path] = {
    for {
      pathSet <- pathSets
      path <- pathSet
      if (path.endState contains target)
    } yield path
  }
}

object Run extends App {

  val problem = new PouringProblem(Vector(4, 7, 19))
//  println(problem.pathSets.take(3).toList)
  println(problem.solution(17))
}




