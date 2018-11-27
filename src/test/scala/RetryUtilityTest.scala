import org.scalatest.FunSuite
import com.training.utils.RetryUtility._
import sun.tools.jconsole.Plotter.Unit
import scala.concurrent.duration._

object RetryUtilityTest {
  private var counter = 0
}

class RetryUtilityTest extends FunSuite{

  test("3rd chance Time Success"){
    assert(RetryUtilityTest.counter == 0)
    assert(retry(dummyMethod())(new RetryParamters(5, 1 seconds)) == Some(1))
    assert(RetryUtilityTest.counter == 3)
  }

  test("Failure test with maximum retry"){
    assertThrows[java.lang.Exception](retry(dummyExceptionMethod()))
  }

  // Missing one test case - fails a few times and succeeds

  def dummyMethod(): Int = {
    RetryUtilityTest.counter += 1;

    if(RetryUtilityTest.counter != 3){
      throw new Exception("Test Exception")
    }

    return 1
  }

  def dummyExceptionMethod(): Int = {
    throw new Exception("Test Exception")
  }
}


