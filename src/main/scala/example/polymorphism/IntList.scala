package example.polymorphism

/**
  * Created by adiko on 24/01/2016.
  */
object IntList {

  def apply(): List[Int] = {
    new NilList[Int]
  }

  def apply(x: Int): List[Int] = {
    new ConsList[Int](x, new NilList[Int])
  }

  def apply(x: Int, y: Int): List[Int] = {
    new ConsList[Int](x, new ConsList[Int](y, new NilList[Int]))
  }

}
