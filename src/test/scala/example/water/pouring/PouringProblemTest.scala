package example.water.pouring

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by adiko on 10/02/2016.
  */
class PouringProblemTest extends Specification {

  abstract class Context extends Scope {
  }

//  "given 2 glasses, moves" should {
//    "return the avaialbe moves" in new Context {
//      private val glasses: Vector[Int] = Vector(4, 7)
//      private val expectedMoves: Vector[Move with Product with Serializable] = Vector(EmptyGlass(0), EmptyGlass(1), FillGlass(0), FillGlass(1), PourGlasses(0, 1), PourGlasses(1, 0))
//      PouringProblem(glasses).moves must be_===(expectedMoves)
//    }
//  }

}
