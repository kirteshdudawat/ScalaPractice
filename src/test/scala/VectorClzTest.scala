import org.scalatest.{FunSuite, Matchers}
import com.training.utils.{MathUtils, VectorClz}
import com.training.utils.DoubleComparator

class VectorClzTest extends FunSuite with Matchers{

  val vec = new VectorClz(Seq(1,2,3))

  test("Variable X check"){
    vec.x should equal (List(1,4,9))
  }

  test("Variable Y check"){
    assert(vec.y == 14)
  }

  test("Variable Z check"){
    assert(DoubleComparator.~=(vec.z,3.7)(0.1)==true)
  }

}
