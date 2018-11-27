import org.scalatest.{FunSuite, Matchers}
import com.training.utils.UtilityMethods

class UtilityMethodsTest extends FunSuite with Matchers{

  val utilityMethods = new UtilityMethods();

  test("First Non None Test 1"){
    assert(utilityMethods.returnFirstNonNone(Some(5),Some(5),Some(6)) == 5)
  }

  test("First Non None Test 2"){
    assert(utilityMethods.returnFirstNonNone(None,None,Some(6)) == 6)
  }

  test("First Non None Test 3"){
    assert(utilityMethods.returnFirstNonNone(None,None,None) == None)
  }

  test("Variable Length First Non None Test 1"){
    assert(utilityMethods.returnFirstNonNoneV1(Some(5),Some(5),Some(6),Some(8)) == 5)
  }

  test("Variable Length First Non None Test 2"){
    assert(utilityMethods.returnFirstNonNoneV1(None,None,Some(6)) == 6)
  }

  test("Variable Length First Non None Test 3"){
    assert(utilityMethods.returnFirstNonNoneV1(None) == None)
  }

  test("List Map multiply Test"){
    utilityMethods.listMapMultiply(List(1, 2, 3, 4), Map(1 -> 3, 3 -> 5)) should equal (List(3,15))
  }
}
