package example.spec2.matchers

/**
  * Created by adiko on 21/02/2016.
  */
import example.spec2.matchers.WorkshopMatchers._
import example.spec2.matchers.PersonMatchers._
import org.specs2.matcher.Matchers._
import org.specs2.matcher.{Matcher, Matchers}
import org.specs2.mutable.SpecWithJUnit

class AdaptWorkshopTest extends SpecWithJUnit {



  "Adapt matchers" should {

    "be able to match person who is middle aged" in {
      Person(age = 50) must beMiddleAged
    }

    "be able to match female person" in {
      Person(sex = "Female") must beFemale
      Person(sex = "Male") must not(beFemale)
    }

    "be able to match tall person" in {
      Person(height = 2.0d) must beTall
      Person(height = 1.3d) must not(beTall)
    }

    "be able to match sum of a list" in {
      Seq(30, 40, 30) must haveSumOf(100)
    }

    "be able to match average of a list" in {
      Seq(25, 25, 100) must haveAverageOf(50)
    }
  }

  "Adapt Matcher Function" should {

    "match a Workshop with some of the specified developers" in {
      Workshop( developers = Seq( Person(name = "dev1"), Person(name = "dev2") ) ) must haveDevelopers(developers = Person(name = "dev1"))
    }

    "compose matchers together" in {
      Some(Workshop( developers = Seq( Person(name = "dev1") ) )) must beSome( haveDevelopers(developers = Person(name = "dev1")) )
    }

    "be able to match a workshop room" in {
      Workshop(room = Some("room")) must beWorkshopWith(room = "room")
    }

    "be able to match workshop with some developers and no room" in {
      Workshop( developers = Seq( Person(name = "dev1"), Person(name = "dev2") ), room = Some("room") ) must beWorkshopWith(room = "room", developers = Person(name = "dev1"))
    }

    "be able to compose Seq[Person] matcher" in {
      Workshop( developers = Seq( Person(name = "dev1") ) ) must beWorkshopThat( contain(Person(name = "dev1")) )
    }
  }

  "Alter Matcher function" should {
    "person should be equal even if they have different names" in {
      val person =  Person(name = "dev1")

      person.copy(name = "another name") must beSameAs( person )
    }

    "compare workshops only by person excluding names" in {
      Workshop( developers = Seq( Person(name = "dev1"), Person(name = "dev2") ) ) must haveTheSameDevelopersAs( Person(name = "dev4"), Person(name = "dev3") )
    }
  }

}

object PersonMatchers {
  import Matchers._

  def beMiddleAged: Matcher[Person] = beBetween(40, 60) ^^ { (p: Person) => p.age }

  def beFemale: Matcher[Person] = beEqualTo("Female") ^^ { (p: Person) => p.sex }

  def beTall: Matcher[Person] = be_>(1.80d) ^^ { (p: Person) => p.height }

  def haveSumOf(sum: Int): Matcher[Seq[Int]] = beEqualTo(sum) ^^ { (s: Seq[Int]) => s.sum }

  def haveAverageOf(avg: Int): Matcher[Seq[Int]] = beEqualTo(avg) ^^ { (s: Seq[Int]) => s.sum/s.length }

  def beSameAs(p: Person): Matcher[Person] =
    be_===( p ) ^^^ { (p: Person) =>  p.copy(name = "some name")}
}

object WorkshopMatchers {
  import Matchers._

  def haveDevelopers(developers: Person*): Matcher[Workshop] = (contain(developers.toSet) : Matcher[Seq[Person]]) ^^ { (_: Workshop).developers aka "developers" }

  def beWorkshopWith(room: String): Matcher[Workshop] = (be_===(Some(room)) : Matcher[Option[String]]) ^^ { (_: Workshop).room aka "room" }

  def beWorkshopWith(room: String, developers: Person*): Matcher[Workshop] = beWorkshopWith(room) and haveDevelopers(developers: _*)

  def beWorkshopThat(matches: Matcher[Seq[Person]]): Matcher[Workshop] = matches ^^ { (_: Workshop).developers aka "developers" }

  def haveTheSameDevelopersAs(developers: Person*): Matcher[Workshop] =
    contain(allOf(developers.map(beSameAs):_* )) ^^ { (_: Workshop).developers aka "developers"}

  // developers.map( person => Matcher[Person] )
  //  containTheSameElementsAs(developers) ^^ { (_: Workshop).developers aka "developers"}
}


case class Person(age: Int = 50, sex: String = "Male", name: String = "Jimmie", height: Double = 1.90d)

case class Workshop(developers: Seq[Person] = Seq.empty, room: Option[String] = None)