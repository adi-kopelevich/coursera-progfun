package example.mnemonics

import com.wixpress.hoopoe.test._
import example.lists.ReductionList
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by adiko on 08/02/2016.
  */
class NumberTranslatorTest extends Specification {

  abstract class Context extends Scope {

  }

  "given a letter, letterToDigit" should {
    "return the digit for that letter" in new Context {
      new NumberTranslator().letterToDigit('A') must be_===('2')
    }
  }

  "given a word, wordToDigitString" should {
    "return the digit string that represent this word" in new Context {
      new NumberTranslator().wordToDigitString("Java") must be_===("5282")
    }
  }

  "given a number, digitsToWords" should {
    "return the set of words that corresponds to the given digits" in new Context {
      new NumberTranslator().digitsToWordsMap("5282") must contain("lava")
    }
  }

  "given a number, digitsToWords" should {
    "return the set of words that corresponds to the given digits" in new Context {
      new NumberTranslator().breakToListOfWords("7225247386") must contain(List("scala", "is", "fun"))
    }
  }

  "given a phone number, translate" should {
    "return all phrases of words that can serve mnemonics for that phone number" in new Context {
      new NumberTranslator().translate("7225247386") must contain("scala is fun")
    }
  }

}
