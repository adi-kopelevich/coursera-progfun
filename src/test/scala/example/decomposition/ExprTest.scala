package example.decomposition

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import com.wixpress.hoopoe.test._


/**
  * Created by adiko on 25/01/2016.
  */
class ExprTest extends SpecificationWithJUnit {


  class ctx extends Scope {
    val randomNum1 = randomInt
    val randomNum2 = randomInt
    val sumOfRandomNums = randomNum1 + randomNum2
    val simpleSumExpression = Sum(Number(randomNum1), Number(randomNum2))
    val simpleSumProdExpression = Sum(Prod(Number(randomNum1), Var("x")), Var("y"))
    val simpleProdSumExpression = Prod(Sum(Number(randomNum1), Var("x")), Var("y"))

  }

  "given a sum expression" should {

    "eval return sum of left eval and right eval expressions" in new ctx {
      simpleSumExpression.eval must beEqualTo(sumOfRandomNums)
    }

    "show returns a string representation of the expression" in new ctx {
      simpleSumExpression.show must beEqualTo(s"${randomNum1} + ${randomNum2}")
    }
  }

  "given a complex expression" should {
    "show must reflect the expression order" in new ctx {
      simpleSumProdExpression.show must beEqualTo(s"${randomNum1} * x + y")
    }
  }

  "given a complex expression" should {
    "show must reflect the parentheses order between sum and prod" in new ctx {
      simpleProdSumExpression.show must beEqualTo(s"(${randomNum1} + x) * y")
    }
  }

}
