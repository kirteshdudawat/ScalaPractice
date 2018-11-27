import org.scalatest.FunSuite
import com.training.tree.{EmptyTree, IntTree, Node}

class TreeTest extends FunSuite{

  val treeTest = Node(2, Node(1, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))

  test("Test contains method"){
    assert(IntTree.contains(treeTest, 2) == true)
    assert(IntTree.contains(treeTest, 3) == true)
  }

  test("Test Insertion") {
    val tree = IntTree.insert(treeTest, 4)
    assert(IntTree.contains(tree, 4) == true)
  }

}
