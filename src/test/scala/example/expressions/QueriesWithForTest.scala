package example.expressions

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by adiko on 04/02/2016.
  */
class QueriesWithForTest extends SpecificationWithJUnit {


  class Context extends Scope {
    val library = List(Book("aba", List("moshe")),
      Book("d", List("eli", "moshe")),
      Book("cb", List("haim", "eli")))
    val mosheBooks = List("aba", "d")
    val booksWithB = List("aba", "cb")
  }

  "given a lib of books and a name, findAuthorsBooks" should {
    "return a list of books which its author is the given name" in new Context {
      new QueriesWithFor().findAuthorsBooks(library, "moshe") must be_===(mosheBooks)
    }
  }

  "given a lib of books and a word, findBooksWithTittleContains" should {
    "return a list of books which its author is the given name" in new Context {
      new QueriesWithFor().findBooksWithTittleContains(library, "b") must be_===(booksWithB)
    }
  }

  "given a lib of books and a number n, findAuthorsBooks" should {
    "return a list of authors who have written at least n books" in new Context {
      new QueriesWithFor().findAuthorsBooks(library, 2) must be_===(List("moshe","eli"))
    }
  }

}
