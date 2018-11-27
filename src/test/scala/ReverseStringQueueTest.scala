import org.scalatest.FunSuite

import com.training.queue.ManualGenericQueue
import com.training.queue.ReverseStringQueue

class ReverseStringQueueTest extends FunSuite{

  val queue = new ManualGenericQueue[String] with ReverseStringQueue

  test(" Reverse String Queue String test"){
    queue.enqueue("Hello")
    assert(queue.dequeue == Some("olleH"))
  }

}
