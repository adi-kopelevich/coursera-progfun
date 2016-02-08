package example.mnemonics

import scala.io.Source

/**
  * Created by adiko on 08/02/2016.
  */
class NumberTranslator {


  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

  val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter)) map (x => x.toLowerCase)

  val digitToMnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  val digitsToWordsMap: Map[String, List[String]] = words groupBy wordToDigitString withDefaultValue List()

  def letterToDigit(letter: Char): Char = {
    val m = for {
      (digit, mnem) <- digitToMnem
      mnemLetter <- mnem
    } yield mnemLetter -> digit
    m(letter)
  }

  def wordToDigitString(word: String): String = {
    word.toUpperCase map letterToDigit
  }

  def breakToListOfWords(numberStr: String): Set[List[String]] = {
    if (numberStr.isEmpty) {
      Set(List())
    } else {
      (for {
        brkInd <- 1 to numberStr.length
        head <- digitsToWordsMap(numberStr take brkInd)
        tail <- breakToListOfWords(numberStr drop brkInd)
      } yield head :: tail).toSet
    }
  }

  def translate(numberStr: String): Set[String] = {
    for (listOfWords <- breakToListOfWords(numberStr))
      yield listOfWords mkString " "
  }

}
