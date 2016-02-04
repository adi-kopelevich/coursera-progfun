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
      author <- book.authors
      if author == authorName
    } yield
      book.title

//    Compiler translate for expression using flatmap (multi generator), withFilter (conditions) and map(yield result)
//
//    library.flatMap(book => book.authors
//      withFilter(author => author == authorName)
//      map(book => book.title))
//    )

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
