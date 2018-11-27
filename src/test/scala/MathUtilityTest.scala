import org.scalatest.FunSuite

import com.training.utils.MathUtils._
import com.training.utils.DoubleComparator.DoubleComparison
import com.training.utils.DoubleComparator

class MockOutput {
  var messages: Seq[String] = Seq()

  def print(s: Any): Unit = {
    messages = messages :+ s.toString
    //super.print(s)
  }
}


class MathUtilityTest extends FunSuite{


  test("gcd(14,21)=7"){
    assert(gcd(14,21)==7)
  }

  test("gcd(14,0)=14"){
    assert(gcd(14,0)==14)
  }

  test("gcd(0,14)=14"){
    assert(gcd(0,14)==14)
  }

  test("gcd(9,9)=9"){
    assert(gcd(9,9)==9)
  }

  test("Even Unsorted List = Avg of two centric element"){
    assert(medianCalculator(Seq(5.5,6,7,8, 1.0,2.0,3.0,4.5))== 5.0)
  }

  test("Odd Unsorted List = centric element"){
    assert(medianCalculator(Seq(6,7,8, 1.0,2.0,3.0,4.5))== 4.5)
  }

  test("Empty List = 0.0"){
    assert(medianCalculator((new Array[Double](5)).toSeq)== 0.0)
  }

  test ("Double Comparator"){
    assert(DoubleComparator.~=(5.0,5.0)==true)
  }

  test ("Double Comparator with all parameter"){
    assert(DoubleComparator.~=(5.0,5.3)(0.5)==true)
  }

  test ("Double Comparator with all parameter and Implicit class"){
    assert((5.0~=5.3)== true)
  }

  test("Failed Double Comparator"){
    assert(DoubleComparator.~=(5.0,5.3)(0.2)==false)
  }

  test("Successful Execution though timeit"){
    assert(timeit(gcd(21,-14))(println)==7)
  }


  test("Test time calculation"){
    val testOut = new MockOutput()

    val t0 = System.nanoTime()
    timeit(_print1())(testOut.print)

    val t1 = System.nanoTime()
    val innerTime= (t1-t0)/1000000
    println(s"Base ${(t1-t0)/1000000} ms")

    val time_taken = testOut.messages(0).substring(testOut.messages(0).indexOf(": ")+2,testOut.messages(0).size-3)
    assert( (time_taken.toLong > 2000 && time_taken.toLong < innerTime) == true)
  }

  def _print1() : Unit = {
    Thread.sleep(2000)
    (0 to 5000).foldLeft(0)(_+_)
  }
}

