import com.training.set.{ EmptySet, NonEmptySet}
import org.scalatest.FunSuite

class IntSetTest extends FunSuite{

  val set = new NonEmptySet(1,EmptySet, EmptySet)


  test("test isEmpty"){
    assert(EmptySet.isEmpty == true)
  }

  test("test contains method"){
    assert(set.contains(1) == true)
  }

  test("test incl method"){
    val set1 = set.incl(2)
    assert(set1.contains(2) == true)
  }

  test("test excl method"){
    val set1 = set.incl(2)
    assert(set1.contains(2) == true)
    val set2 = set.excl(2)
    assert(set2.contains(2) ==  false)
  }

  test("union"){
    val set1 = set.incl(2)
    val set2 = set.incl(3)
    val set3 = set1.union(set2)
    assert(set3.contains(1) == true)
    assert(set3.contains(2) == true)
    assert(set3.contains(3) == true)
  }

  test("Intersection"){
    val set1 = set.incl(2).incl(3).incl(4).incl(5)
    val set2 = set.incl(3).incl(4).incl(5).incl(6).incl(7)
    val set3 = set1.intersect(set2)
    assert(set3.contains(1) == true)
    assert(set3.contains(3) == true)
    assert(set3.contains(4) == true)
    assert(set3.contains(5) == true)
    assert(set3.contains(2) == false)
    assert(set3.contains(6) == false)
    assert(set3.contains(7) == false)
  }

}
