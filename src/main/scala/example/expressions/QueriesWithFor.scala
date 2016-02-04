package example.expressions

/**
  * Created by adiko on 04/02/2016.
  */
class QueriesWithFor {


  def findBooksWithTittleContains(library: List[Book], s: String): List[String] = {
    for {
      books <- library
      if (books.title indexOf s) >= 0
    } yield
      books.title
  }


  def findAuthorsBooks(library: List[Book], authorName: String): List[String] = {
    for {
      book <- library
      authors <- book.authors
      if authors contains authorName
    } yield
      book.title
  }

  def findAuthorsBooks(library: List[Book], n: Int) = {
    val listOfBooksAuthors = for {
      book <- library
      author <- book.authors
    } yield author

    val setOfBooksAuthors = listOfBooksAuthors.toSet

    for {
      uniqueAuthor <- setOfBooksAuthors
      if listOfBooksAuthors.count(_ == uniqueAuthor) >= n
    } yield uniqueAuthor
  }
}

case class Book(title: String, authors: List[String])
