import org.scalatest.{FunSuite, Matchers}
import com.training.utils.StringUtils

class StringUtilsTest extends FunSuite with Matchers{

  val stringUtils = new StringUtils

  test("String Array to Character Array"){
    var list = List("Hello", "Kirtesh")
    stringUtils.stringArrayToCharacterArray(list).toSeq should equal (List('H','e','l','l','o','K','i','r','t','e','s','h').toSeq)
  }

  test("Longest word in Sentence"){
    assert(stringUtils.findLongestWord("Hello My Name is Kirtesh")=="Kirtesh")
  }

  test("Longest word in Empty Sentence"){
    assert(stringUtils.findLongestWord("")=="")
  }

  test("Most Common Word in Sentence"){
    assert(stringUtils.mostCommonWord("Hello My Name is Kirtesh. I work at Agoda. Bla Bla")=="Bla")
  }

  test("Most Common Letter in Sentence"){
    assert(stringUtils.mostCommonLetter("Hello My Name is Kirtesh. I work at Agoda. Bla Bla")=='a')
  }

  test("squareList Test 1"){
    stringUtils.squareList(List(1,2,3)).toSeq should equal (List(1,4,9).toSeq)
  }

  test("squareList Test"){
    stringUtils.squareListV1(List(1,2,3)).toSeq should equal (List(1,4,9).toSeq)
  }
}
