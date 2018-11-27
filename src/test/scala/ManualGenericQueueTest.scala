import org.scalatest.FunSuite
import com.training.queue.ManualGenericQueue

class ManualGenericQueueTest extends FunSuite{

  val queue = new ManualGenericQueue[Int]
  val queue1 = new ManualGenericQueue[Int]

  test("IsEmpty Test"){
    assert(queue.isEmpty == true)
    queue.enqueue(4)
    assert(queue.isEmpty == true)
    queue.enqueue(5)
    queue.enqueue(6)
    assert(queue.isEmpty == false)
    queue.dequeue
    queue.dequeue
    queue.dequeue
  }

  test("testing Dequeue on Empty Queue"){
    assert(queue.dequeue == None)
  }

  test("testing successful enqueue"){
    queue1.enqueue(10)
    assert(queue1.dequeue == Some(10))
  }

  test("testing Sucessfule dequeue"){
    queue1.enqueue(100)
    assert(queue1.dequeue == Some(100))
  }
}
